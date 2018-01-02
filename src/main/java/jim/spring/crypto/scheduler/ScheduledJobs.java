package jim.spring.crypto.scheduler;

import jim.spring.crypto.controllers.CryptoController;
import jim.spring.crypto.entity.TotalValue;
import jim.spring.crypto.entity.Wallet;
import jim.spring.crypto.repository.TotalValueRepository;
import jim.spring.crypto.services.WalletService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jim on 1-12-17.
 */
@Component
public class ScheduledJobs {

    private final static Logger logger = LoggerFactory.getLogger(ScheduledJobs.class);

    private WalletService walletService;
    private TotalValueRepository totalValueRepository;

    public ScheduledJobs(WalletService walletService, TotalValueRepository totalValueRepository) {
        this.walletService = walletService;
        this.totalValueRepository = totalValueRepository;
    }

    @Scheduled(fixedRate = 60000L)
    public void storeValues() throws IOException {
        List<Wallet> wallets = walletService.getWallets("EUR");
        Double total = walletService.getTotalWallets(wallets);
        totalValueRepository.save(new TotalValue(total, LocalDateTime.now()));
        walletService.saveWallets(wallets);
        logger.info(total.toString());
    }
}
