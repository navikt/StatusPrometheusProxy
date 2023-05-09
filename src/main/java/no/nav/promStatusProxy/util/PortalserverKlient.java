package no.nav.promStatusProxy.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import no.nav.promStatusProxy.dtos.RecordDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class PortalserverKlient {

    static String portalApiUrl = System.getenv("portalserver_path");


    public static void postStatus(RecordDto recordDto) throws Exception {
        URL url = new URL (portalApiUrl + "/rest/UpdateRecords");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty ("Authorization",  OauthUtil.getAccessTokenForPortal());
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(RecordDto.class,new RecordDto.RecordDtoAdapter())
                .create();
        String jsonInputString = gson.toJson(List.of(recordDto));
        System.out.println(jsonInputString);
        System.out.println("HEi");
        try(OutputStream os = con.getOutputStream()) {

            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response);
            System.out.println("Postet status ok");
        }
    }
}
