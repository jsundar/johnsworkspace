package com.dp.creation.pattern.main;

import com.dp.creation.builder.Meal;
import com.dp.creation.builder.MealBuilder;

public class BuilderFactory {
   public static void main(String[] args) {
      MealBuilder mealBuilder = new MealBuilder();
      Meal vegMeal = mealBuilder.prepareVegMeal();
      System.out.println("Veg Meal");
      vegMeal.showItems();
      System.out.println("Total Cost: " + vegMeal.getCost());

      Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
      System.out.println("\n\nNon-Veg Meal");
      nonVegMeal.showItems();
      System.out.println("Total Cost: " + nonVegMeal.getCost());
   }
}
