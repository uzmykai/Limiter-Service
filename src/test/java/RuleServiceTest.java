import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.uz.model.Rule;
import org.uz.model.request.RuleRequest;
import org.uz.repository.RuleRepository;
import org.uz.service.RuleService;

@ExtendWith(MockitoExtension.class)
public class RuleServiceTest {

    @Autowired
    RuleService ruleService;

    @Mock
    RuleRepository repository;

    Rule ruleModel;

    @Test
    public void whenRegisterRuleIsCalled_AndRuleDoesNotExist_ReturnOK(){
        ruleModel =  new Rule();
        ruleModel.setId(1);
        RuleRequest req = new RuleRequest();
        Mockito.when(repository.save(ruleModel)).thenReturn(ruleModel);
        var result =  ruleService.createRule(req);
        Assert.hasText(result.getStatusCode().toString(),
                String.valueOf(HttpStatus.OK));
    }
}
