/*
 * Copyright 2017 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.crafting;


import org.terasology.entitySystem.Component;

import java.util.Map;
import java.util.TreeMap;


public class ListRecipesComponent implements Component, RecipeComponent {

    public String category = "InHand";
    public Map<String, ListRecipeContainer> recipes = new TreeMap<>();

    public Recipe[] getRecipes() {
        Recipe[] builtRecipes = new Recipe[recipes.size()];
        int i = 0;
        for (Map.Entry<String, ListRecipeContainer> entry : recipes.entrySet()) {
            ListRecipe recipe = new ListRecipe(entry.getValue(), entry.getKey());
            builtRecipes[i] = recipe;
            i++;
        }
        return builtRecipes;
    }

    public String getCategory() {
        return category;
    }
}
