package it.paleocapa.mastroiannim;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.glxn.qrgen.javase.QRCode;


@Controller
public class TemplateHomeController {

    @Value("${telegram.username}")
    private String botUsername;

    private static final Logger LOG = LoggerFactory.getLogger(TemplateHomeController.class);


    @GetMapping("/")
    public String generateQrCode(Model model) {

        String botUrl = "https://telegram.me/" + botUsername;
        LOG.info(botUrl);

        ByteArrayOutputStream stream = QRCode
            .from(botUrl)
            .withSize(250, 250)
            .stream();
    
        byte[] qr = stream.toByteArray();
        String qrCodeImage = "data:image/png;base64," + Base64.getEncoder().encodeToString(qr);

        model.addAttribute("qrCodeImage", qrCodeImage);
        model.addAttribute("botUrl", botUrl);
        
        return "index";
    }

    @GetMapping("/hello")
	public String index(
        @RequestParam(name="name", required=false, defaultValue="World") 
        String name, 
        Model model
    ) {
		model.addAttribute("name", name);
		return "hello";
	}
}
