/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab6.entities;

import lombok.Data;
import lombok.AllArgsConstructor;

/**
 *
 * @author Bartek
 */
@Data
@AllArgsConstructor
public class Distance {
    
    private double srcLat;
    private double srcLon;
    private double dstLat;
    private double dstLon;
    private double distance;
    
}
