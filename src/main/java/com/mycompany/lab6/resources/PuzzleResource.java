/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab6.resources;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mycompany.lab6.entities.Distance;
import com.mycompany.lab6.entities.Puzzle;
import com.mycompany.lab6.servlets.PuzzleContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Bartek
 */
@Path("/puzzle")
public class PuzzleResource {
    private static final String PUZZLE_CONTEXT = "puzzleContext";
    
    @Context
    ServletContext context;

    @Context
    HttpServletRequest request;

    @Context
    HttpServletResponse response;
    
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Puzzle> listPuzzle(@DefaultValue("-1") @QueryParam("sort") String sort) {
        return getPuzzleContext().getPuzzle(sort);
    }
    
    @GET
    @Path("{id:[0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Puzzle getPuzzle(@PathParam("id") Integer puzzleId) {
        return getPuzzleContext().getPuzzle(puzzleId);
    }
    
    @DELETE
    @Path("{id:[0-9]+}")
    public Response deletePuzzle(@PathParam("id") Integer puzzleId) {
        getPuzzleContext().deletePuzzle(puzzleId);
        return Response.ok().build();
    }

    private PuzzleContext getPuzzleContext() {
        PuzzleContext puzzleContext = (PuzzleContext) context.getAttribute(PUZZLE_CONTEXT);
        if(puzzleContext == null){
            puzzleContext = new PuzzleContext();
            context.setAttribute(PUZZLE_CONTEXT, puzzleContext);
        }
        return puzzleContext;
    }
         
}
