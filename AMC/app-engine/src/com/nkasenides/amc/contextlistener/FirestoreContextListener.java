package com.nkasenides.amc.contextlistener;

import com.google.cloud.firestore.DocumentReference;
import com.nkasenides.amc.model.*;
import com.nkasenides.amc.persistence.AMCPlayerDAO;
import com.nkasenides.amc.persistence.AMCWorldDAO;
import com.raylabz.firestorm.Firestorm;
import com.raylabz.firestorm.util.FirebaseUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

public class FirestoreContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        //Init Firestore:
        final String SERVICE_ACCOUNT = "{\n" +
                "  \"type\": \"service_account\",\n" +
                "  \"project_id\": \"amazechallenge2\",\n" +
                "  \"private_key_id\": \"b101be4e851ad7117e03dbe3e3368bdfaf936bc0\",\n" +
                "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDYXoGI+I8a8CNJ\\nV5Cj+kmXreHQN4kp70+c2NLZZFUEZM31k3F9JAMONelDPvGDiDNoZCE/dns/RjpF\\nRpNK4Dq37ZgOJAQi8kcWU/JRbGmIoaIj6Fm6vLmbDahEqcHehV6sGPXJKhG/7VD3\\n4RC2SuytTjg1lqQLv4Kf0WerSJWAbfJ+nm+eLMMQ2qYZEozFKY7hPS7UbEhmNw0K\\n89CCPOBmAnVgqqYGgG8xilf4sAmf1WmISzQtfuG678wnuwHIInNbGygDp2z3GMDG\\nKGgTb6QZzgpJPClMBQqYriW4Ced0Xran9KKO9ggOvhdTK+Y704ecJGaDOilnrtzS\\n3vivHh3dAgMBAAECggEAZYVCRiBKFRujkuARL79aFF8z2tyT8ScmNbPOis32zg72\\nTEmYMF1bSaml/zVjYJHhfROuPfa7sV6kLKkGp1U6d951P/1KK5N+I03UHrw9cCxW\\nxX5Zy7KNa+EmmMEGBACUAS/c8zxYA7O4D/Z8Puw8zLwsx4gdBJ4hDhfVCpsN+qm+\\n+8gd/CSjlxu1A4oeWDkiIkiSch+6lB+JzY/5mL1B6X+hTvYyAjC0qLW0h2oHlmGl\\n81Z96RbZEPJvj6oK42On9kLHn4KznkTNIw9N9bPsXVGvitBg0rKDvAsW5usLQFBR\\nKeo2LH9r3pcBLS2k9zt/WNTc8fCNI4Dy4mz2CsPtyQKBgQDwYSpxAmvF54jilQsz\\n4I3x7eNqtHVNhSX2/nYTWzSaE+OHF7W5apposTyte5+u2XOS1WLLvYi4o73JY+CP\\nMDqGjo24Zuh51P1B6UJM5jrmDCjbJjtR0zDZyT+A9skIXL1s+4B3fMp8b0y8pCV+\\nTGkrjeLtoEuxtnw2mXbDc4FyuwKBgQDmbepUuN7HWXHl43FYPaRVvd0ZM+CQDSfy\\nn8yV5sm2tGl3y7dtHRVFrX1TZcgu8phqesrTkc43AxX3oAZiKgaAI6DAXUWXmQ3u\\nMEwMUOfM4ON3VCfsV7d7VTYbifDytjqPIyBdsu7iibCpON3texeE3PO//mAlxY+B\\nYdGiaW8kRwKBgD0A67xyWNeIwvx9xrILsvpK3QQfeAWMXO4p9d1DsD3J/lwycDP2\\nEemv0S5VyVieZu5EqSX7m87//xI0/rBYFQJA+0ZpF2aT3xHzGJhbdWccfuHe+f7y\\nEduzbyJTfwFYR9p4mUm5qcmalWbqYXmD+szK3WRg4dTf8vYITFOd5KQxAoGAVDOe\\nCU90uMvKfwLZjDEaN+qlPGxkhr8H9fTGwZAP7Z+HWqsqX8jc2RVIUo1C1UT4xRAR\\nxbXl8NxDzrS/IGfS8EgUmbZ7k6XuHTew0l9OFOOouxYZcJetCHheyTlivo4wX9Wq\\nIhMcj9NYpr2M+xabxYUn3OSLJcJHajPgcsSsREkCgYEAs4xPFqwlYX0JvHXWgwyI\\nfi0i/1bXRrcYVhQLL6ie5gtXPnXSdN60ih2hWpLvFMG2uirvq1hCmE8ljw8WsQ3B\\nA1SRMa6XQAEdP8XeZYcqq5bhnxNVr9Fx352Dj2CAp9imFpyfsMecCJkb1VKe5o8m\\nvdAPqwmrDOc2l7/C/997wrw=\\n-----END PRIVATE KEY-----\\n\",\n" +
                "  \"client_email\": \"firebase-adminsdk-7tg1c@amazechallenge2.iam.gserviceaccount.com\",\n" +
                "  \"client_id\": \"111653877930330216786\",\n" +
                "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-7tg1c%40amazechallenge2.iam.gserviceaccount.com\"\n" +
                "}\n";

        try {
            FirebaseUtils.initialize(SERVICE_ACCOUNT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Firestorm.init();
        Firestorm.register(AdminKey.class);
        Firestorm.register(AMCPlayer.class);
        Firestorm.register(AMCTerrainChunk.class);
        Firestorm.register(AMCTerrainIdentifier.class);
        Firestorm.register(AMCWorld.class);
        Firestorm.register(AMCWorldSession.class);
        Firestorm.register(Challenge.class);
        Firestorm.register(Grid.class);
        Firestorm.register(PickableEntity.class);
        Firestorm.register(PlayerEntity.class);
        Firestorm.register(QuestionEntry.class);
        Firestorm.register(QuestionnaireEntry.class);

        //Clear previous admin keys:
        Firestorm.getCollectionReference(AdminKey.class).listDocuments().forEach(DocumentReference::delete);

        //Create a new admin key:
        AdminKey adminKey = new AdminKey();
        adminKey.setId(UUID.randomUUID().toString());
        Firestorm.create(adminKey);

    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
