/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab6.servlets;

import com.mycompany.lab6.entities.Puzzle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bartek
 */
public class PuzzleContext implements Serializable {
    private Map<Integer, Puzzle> puzzles;
    
    public PuzzleContext(){
        puzzles = new HashMap<>();
        initPuzzle();
    }
    
    private void initPuzzle(){
        addPuzzle(new Puzzle("star wars", 10.1, 10.1, 100));
        addPuzzle(new Puzzle("frozen", 10, 10, 50));
        addPuzzle(new Puzzle("minions", 40, 80, 500));
        addPuzzle(new Puzzle("winter", 150, 92, 4000));
        addPuzzle(new Puzzle("winter", 130, 86, 3000));
        addPuzzle(new Puzzle("spring", 130, 86, 3000));
    }
    
    public List<Puzzle> getPuzzle(){
        return new ArrayList(puzzles.values());
    }
    
    public List<Puzzle> getPuzzle(String sort){
        List<Puzzle> result = getPuzzle();
        if(sort.equals("names")){
            result.sort(Comparator.comparing(Puzzle::getName));
        } else if(sort.equals("surface")){
            result.sort(Comparator.comparing(Puzzle::getSurface));           
        } else if(sort.equals("numberOfElements")){
            result.sort(Comparator.comparing(Puzzle::getNumberOfElements));           
        } else if(sort.equals("width")){
            result.sort(Comparator.comparing(Puzzle::getWidth));           
        } else if(sort.equals("height")){
            result.sort(Comparator.comparing(Puzzle::getHeight));           
        }
        return result;
    }
    
    public Puzzle getPuzzle(int id){
        return puzzles.get(id);
    }
    
    public void addPuzzle(Puzzle puzzle){
        puzzles.put(puzzle.getId(), puzzle);
    }
    
    public void deletePuzzle(int id){
        puzzles.remove(id);
    }
    
    public void updatePuzzle(Puzzle puzzle){
        puzzles.replace(puzzle.getId(), puzzle);
    }
}
