/*
 * Copyright 2017 George Cohn III
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.creationgroundmedia.recipebrowser.util;

import com.creationgroundmedia.recipebrowser.models.Ingredient;

import java.util.List;

/**
 * Created by geo on 3/23/17.
 */

public class Util {
    public static CharSequence buildIngredientsList(List<Ingredient> ingredients) {
        StringBuilder builder = new StringBuilder();
        for (Ingredient ingredient : ingredients) {
            builder.append(ingredient.getQuantity());
            builder.append(' ');
            builder.append(ingredient.getName());
            builder.append('\n');
        }
        return builder.toString();
    }

    public static CharSequence buildMethodStepsList(List<String> steps) {
        StringBuilder builder = new StringBuilder();
        for (String step : steps) {
            builder.append('‣');
            builder.append(' ');
            builder.append(step);
            builder.append('\n');
        }
        return builder.toString();
    }
}
