/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab6.entities;

import lombok.Data;

/**
 *
 * @author Bartek
 */
@Data
public class Puzzle {
    private double width;
    private double height;
    private int numberOfElements;
    private String name;
    private int id;
    
    public Puzzle(String name, double width, double height, int numberOfElements){
        id = IdSupplier.getNextId();
        this.name = name;
        this.height = height;
        this.width = width;
        this.numberOfElements = numberOfElements;
    }
    
    public double getSurface(){
        return width*height;
    }
    
}
