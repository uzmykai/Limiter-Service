import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.uz.model.Client;
import org.uz.model.request.ClientRequest;
import org.uz.repository.ClientRepository;
import org.uz.service.ClientService;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Autowired
    ClientService clientService;

    @Mock
    ClientRepository repository;

    Client client;

    @Test
    public void whenRegisterClientIsCalled_AndClientDoesNotExist_ReturnOK(){
        client =  new Client();
        client.setId(1);
        ClientRequest req = new ClientRequest();
        Mockito.when(repository.save(client)).thenReturn(client);
        var result =  clientService.registerClient(req);
        Assert.hasText(result.getStatusCode().toString(),
                String.valueOf(HttpStatus.OK));
    }
}
