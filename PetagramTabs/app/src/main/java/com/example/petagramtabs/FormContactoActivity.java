package com.example.petagramtabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class FormContactoActivity extends AppCompatActivity {
String correo, contraseña;

EditText descripcion;
Button enviar;
Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formcontacto_main);

        descripcion = (EditText) findViewById(R.id.edit_descripcion);
        enviar = (Button) findViewById(R.id.btn_enviar);

        correo = "correobotandroi@gmail.com";
        contraseña = "Cobotandroi20*";

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "465");

                try {
                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, contraseña);
                        }
                    });

                    if (session!= null){
                        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                        StrictMode.setThreadPolicy(policy);
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("CorreoMascota");
                        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("correobotandroi@gmail.com"));
                        message.setContent(descripcion.getText().toString(), "text/html; charset=utf-8")
                        ;
                        Transport.send(message);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        });    }
}