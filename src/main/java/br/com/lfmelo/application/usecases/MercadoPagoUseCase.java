package br.com.lfmelo.application.usecases;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MercadoPagoUseCase {

    public void testeMercadoPago() {
        try {
            MercadoPagoConfig.setAccessToken("TOKEN");

            PreferenceItemRequest itemRequest =
                    PreferenceItemRequest.builder()
                            .id("1234")
                            .title("Games")
                            .description("PS5")
                            .pictureUrl("http://picture.com/PS5")
                            .categoryId("games")
                            .quantity(2)
                            .currencyId("BRL")
                            .unitPrice(new BigDecimal("4000"))
                            .build();

            List<PreferenceItemRequest> items = new ArrayList<>();
            items.add(itemRequest);

            PreferenceRequest preferenceRequest = PreferenceRequest
                    .builder()
                    .items(items)
                    .notificationUrl("https://webhook.site/d7b0c5dc-275f-465e-8d4b-652c995fcef4")
                    .build();

            PreferenceClient client = new PreferenceClient();

            Preference preference = client.create(preferenceRequest);

            System.out.println(preference.getAdditionalInfo());
        } catch (MPException e) {
            throw new RuntimeException(e);
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }

    }

}
