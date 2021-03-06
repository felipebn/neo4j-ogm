/*
 * Copyright (c) 2002-2018 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with
 * separate copyright notices and license terms. Your use of the source
 * code for these subcomponents is subject to the terms and
 *  conditions of the subcomponent's license, as noted in the LICENSE file.
 */

package org.neo4j.ogm.domain.drink;

import static org.neo4j.ogm.annotation.Relationship.*;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Ingredient is an entity which has only graph id
 */
@NodeEntity
public class Ingredient {

    private Long id;

    private String name;

    @Relationship(type = "CONTAINS", direction = INCOMING)
    private Set<Beverage> beverages;

    public Ingredient() {
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Beverage> getBeverages() {
        return beverages;
    }

    /**
     * Only adds ingredient -> beverage, use {@link org.neo4j.ogm.domain.drink.Beverage#addIngredient(Ingredient)}
     * to add both sides
     */
    public void addBeverage(Beverage beverage) {
        if (beverages == null) {
            beverages = new HashSet<>();
        }
        beverages.add(beverage);
    }
}
