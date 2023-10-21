package com.vcanus.test;

import java.util.HashMap;
import java.util.Map;

// Recipe 클래스 정의
class Recipe {
    private Map<String, Integer> ingredients;

    public Recipe() {
        ingredients = new HashMap<>();
    }

    public void addIngredient(String ingredient, int quantity) {
        ingredients.put(ingredient, quantity);
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }
}

// Bread 클래스 정의
class Bread {
    private String breadType;
    private Recipe recipe;

    public Bread(String breadType, Recipe recipe) {
        this.breadType = breadType;
        this.recipe = recipe;
    }

    public void printBreadProperties() {
        System.out.println("breadType: " + breadType);
        System.out.println("recipe");
        for (Map.Entry<String, Integer> entry : recipe.getIngredients().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }
}

//BreadFactory 인터페이스 정의
interface BreadFactory {
 Bread createBread(String breadType);
}

//구체적인 팩토리 클래스
class BreadFactoryImpl implements BreadFactory {
 @Override
 public Bread createBread(String breadType) {
     Recipe recipe = new Recipe();
     switch (breadType) {
         case "cream":
             recipe.addIngredient("flour", 100);
             recipe.addIngredient("water", 100);
             recipe.addIngredient("cream", 200);
             break;
         case "sugar":
             recipe.addIngredient("flour", 100);
             recipe.addIngredient("water", 50);
             recipe.addIngredient("sugar", 200);
             break;
         case "butter":
             recipe.addIngredient("flour", 100);
             recipe.addIngredient("water", 100);
             recipe.addIngredient("butter", 50);
             break;
         default:
             throw new IllegalArgumentException("잘못된 빵 타입: " + breadType);
     }
     return new Bread(breadType, recipe);
 }
}

public class Test1 {

	public static void main(String[] args) {
		// 팩토리를 사용하여 빵 객체 생성
        BreadFactory breadFactory = new BreadFactoryImpl();

        Bread creamBread = breadFactory.createBread("cream");
        Bread sugarBread = breadFactory.createBread("sugar");
        Bread butterBread = breadFactory.createBread("butter");

        // 빵 속성 출력
        creamBread.printBreadProperties();
        sugarBread.printBreadProperties();
        butterBread.printBreadProperties();
	}

}
