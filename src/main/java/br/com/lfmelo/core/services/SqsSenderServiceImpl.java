package br.com.lfmelo.core.services;

import br.com.lfmelo.adapters.dtos.OrderCheckoutDTO;
import br.com.lfmelo.core.ports.SqsSenderServicePort;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

import java.io.IOException;

@Slf4j
@Service
public class SqsSenderServiceImpl implements SqsSenderServicePort {

    @Value("${aws.sendOrder.url}")
    String queueUrl;

    @Autowired
    private SqsClient sqsClient;

    @Override
    public void publish(OrderCheckoutDTO dto) {
        try {
            SendMessageRequest request = SendMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .messageBody(serializeObjectToJson(dto))
                    .build();

            SendMessageResponse response = sqsClient.sendMessage(request);

            System.out.println("Mensagem enviada com sucesso! MessageId: " + response.messageId());
        } catch (Exception e) {
            System.err.println("Erro ao enviar mensagem: " + e.getMessage());
        }
    }

    public static String serializeObjectToJson(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(object);
            log.info("Pedido para ser enviado a fila: {}", json);
            return json;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao serializar o objeto: " + e.getMessage());
        }
    }
}
