package com.example.petagramtabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AsyncNotedAppOp;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactoActivity extends AppCompatActivity implements View.OnClickListener {

    Session session = null;
    ProgressDialog pdialog = null;
    Context context = null;
    EditText reciep, sub, msg ;
    String rec, subject, textMessage;
    Button enviar;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        context = this;

        msg = (EditText) findViewById(R.id.edit_descripcion);
        sub = (EditText) findViewById(R.id.edit_nombre);
        reciep = (EditText) findViewById(R.id.edit_correo);
        enviar = (Button) findViewById(R.id.btn_enviar);
    }


    @Override
    public void onClick(View view) {
        textMessage = msg.getText().toString();
        subject = sub.getText().toString();
        rec = reciep.getText().toString();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.googlemail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("correobotandroi@gmail.com", "Cobotandroi20*");
            }
        });
        pdialog = ProgressDialog.show(context, "", "Enviando mensaje", true);

        RetrieveFeedTask task = new RetrieveFeedTask();
        task.execute();
    }

    class RetrieveFeedTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("correobotandroi@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(rec));
                message.setSubject("SaludoCorreoMascota");
                message.setContent(textMessage, "text/html; charset=utf-8");
                Transport.send(message);
            }catch(MessagingException e){
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(String result){
            pdialog.dismiss();
            reciep.setText("");
            msg.setText("");
            sub.setText("");
            Toast.makeText(getApplicationContext(), "Mensaje enviado", Toast.LENGTH_LONG).show();
        }
    }
}
