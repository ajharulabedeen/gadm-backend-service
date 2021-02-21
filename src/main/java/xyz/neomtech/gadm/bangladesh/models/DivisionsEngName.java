/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.neomtech.gadm.bangladesh.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author G7
 */
@Entity
@ToString
@Table(name = "zzna_divisions_engname")
public class DivisionsEngName {
    @Getter
    @Setter
    @Id
    private Integer id;
    @Getter
    @Setter
    private String name;
}
