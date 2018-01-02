package jim.spring.crypto.controllers;

import jim.spring.crypto.entity.TotalValue;
import jim.spring.crypto.entity.Wallet;
import jim.spring.crypto.repository.TotalValueRepository;
import jim.spring.crypto.repository.WalletRepository;
import jim.spring.crypto.services.WalletService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static jim.spring.crypto.services.WalletService.round;

/**
 * Created by jim on 15-12-17.
 */
@Controller
public class SiteController {

    private WalletService walletService;
    private TotalValueRepository totalValueRepository;
    private WalletRepository walletRepository;

    public SiteController(WalletService walletService, TotalValueRepository totalValueRepository, WalletRepository walletRepository) {
        this.walletService = walletService;
        this.totalValueRepository = totalValueRepository;
        this.walletRepository = walletRepository;
    }

    @GetMapping("/loginForm")
    public String login() {
        return "loginForm";
    }


    @GetMapping("/")
    public String index(Model model) throws IOException {
        Double total = totalValueRepository.findFirstByOrderByIdDesc().getTotal();

        TotalValue val1h = totalValueRepository.findFirstByTimeBetween(start(1), end(1));
        TotalValue val24h = totalValueRepository.findFirstByTimeBetween(start(24), end(24));
        TotalValue val7d = totalValueRepository.findFirstByTimeBetween(start(24 * 7), end(24 * 7));
        List<Wallet> wallets = walletRepository.findByTimeBetween(LocalDateTime.now().minusMinutes(1), LocalDateTime.now());
        wallets.sort((w1, w2) -> {
            if(w2.getCurrency().equals("EUR")){
                return -1;
            }
            if (w1.getValue() > w2.getValue()) {
                return -1;
            }
            if (w1.getValue() < w2.getValue()) {
                return 1;
            }
            return 0;
        });

        model.addAttribute("wallets", wallets);
        model.addAttribute("total", round(total, 2));
        model.addAttribute("verschil1h", round(getVerschil(total, val1h), 2));
        model.addAttribute("verschil24h", round(getVerschil(total, val24h), 2));
        model.addAttribute("verschil7d", round(getVerschil(total, val7d), 2));
        model.addAttribute("max", round(totalValueRepository.findMaxValue().getTotal(), 2));


        return "index";
    }

    private Double getVerschil(Double total, TotalValue val) {
        if (val != null) {
            return ((total - val.getTotal()) / total) * 100;
        }
        return 0.0D;
    }

    private LocalDateTime start(int i) {
        LocalDateTime now = LocalDateTime.now();
        return now.minusHours(i);
    }

    private LocalDateTime end(int i) {
        LocalDateTime now = LocalDateTime.now();
        return now.minusHours(i).plusMinutes(1);
    }

}
