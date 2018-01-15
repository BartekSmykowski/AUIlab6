/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab6.resources;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mycompany.lab6.entities.Distance;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Bartek
 */
@Path("/distance")
public class DistanceApi {
    
    @Context
    ServletContext context;
    
    @Context
    HttpServletRequest request;

    @Context
    HttpServletResponse response;
    
    @GET
    //@Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDistance(@DefaultValue("-1") @QueryParam("latSrc") double srcLat,
            @DefaultValue("-1") @QueryParam("lonSrc") double srcLon,
            @DefaultValue("-1") @QueryParam("latDst") double dstLat,
            @DefaultValue("-1") @QueryParam("lonDst") double dstLon) {
        
        String key = "AIzaSyDX0OjRMsgV41ul8R1Z0iabVlc1lMl7dAg";
        String address = "https://maps.googleapis.com/maps/api/distancematrix/json?"+
                "origins=" + srcLat + "," + srcLon + 
                "&destinations=" + dstLat + "," + dstLon + 
                "&key=" + key;
        
        JsonElement root = null;
        try {
            URL url = new URL(address);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            
            JsonParser jp = new JsonParser();
            root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

        } catch (MalformedURLException ex) {
            Logger.getLogger(PuzzleResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PuzzleResource.class.getName()).log(Level.SEVERE, null, ex);
        }


        Gson gson = new Gson();
        return gson.toJson(root);

    }
    
}
