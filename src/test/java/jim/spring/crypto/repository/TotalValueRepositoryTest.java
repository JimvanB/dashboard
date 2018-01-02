package jim.spring.crypto.repository;

import jim.spring.crypto.entity.TotalValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by jim on 1-12-17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TotalValueRepositoryTest {

    @Autowired
    TotalValueRepository totalValueRepository;

    @Test
    public void storeTotalValue(){
        TotalValue totalValue = new TotalValue(123D);

        totalValueRepository.save(totalValue);

        assertThat(totalValueRepository.findOne(1L).getTotal(), is(123D));

    }


}