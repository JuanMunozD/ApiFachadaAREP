package edu.eci.arep.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.eci.arep.nanospark.components.NanoSparkException;
import edu.eci.arep.persistence.entity.ResponseCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;

public class PersistenceServiceImpl implements PersistenceService {

    ResponseCalculator resp;

    @Override
    public String getSin(String name) {

        JSONObject json;
        String res = "";
        try {
            json = readJsonFromUrl("https://apicalculatorarepjuanmunoz.herokuapp.com/sin?value=" + name);
                    
            res= json.toString();

            return res ;
        } catch (IOException ex) {
            Logger.getLogger(PersistenceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(PersistenceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public String getCos(String name) {

        JSONObject json;
        String res = "";
        try {
            json = readJsonFromUrl("https://apicalculatorarepjuanmunoz.herokuapp.com/cos?value=" + name);
                    
            res= json.toString();

            return res ;
        } catch (IOException ex) {
            Logger.getLogger(PersistenceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(PersistenceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public String getTan(String name) {

        JSONObject json;
        String res = "";
        try {
            json = readJsonFromUrl("https://apicalculatorarepjuanmunoz.herokuapp.com/tan?value=" + name);
                    
            res= json.toString();

            return res ;
        } catch (IOException ex) {
            Logger.getLogger(PersistenceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(PersistenceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}
