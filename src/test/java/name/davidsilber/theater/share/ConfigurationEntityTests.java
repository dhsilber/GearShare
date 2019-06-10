package name.davidsilber.theater.share;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ConfigurationTests {

    @Autowired
    private ConfigurationRepository configurationRepository;

    @Test
    void whenSaved_thenFindByDefault() {
        configurationRepository
    }
}
