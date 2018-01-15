/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab6.entities;

/**
 *
 * @author Bartek
 */
public class IdSupplier {
    private static int ID;
    
    public static int getNextId(){
        int id = ID;
        ID++;
        return id;
    }
}
