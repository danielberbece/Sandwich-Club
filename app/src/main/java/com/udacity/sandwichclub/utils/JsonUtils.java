package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = new Sandwich();

        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONObject name = jsonObject.getJSONObject("name");

            String mainName = name.getString("mainName");
            sandwich.setMainName(mainName);

            JSONArray otherNames = name.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAsList = new ArrayList<>();
            for (int i = 0; i < otherNames.length(); i++) {
                String tmpName = otherNames.getString(i);
                alsoKnownAsList.add(tmpName);
            }
            sandwich.setAlsoKnownAs(alsoKnownAsList);

            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            sandwich.setPlaceOfOrigin(placeOfOrigin);

            String description = jsonObject.getString("description");
            sandwich.setDescription(description);

            String imageString = jsonObject.getString("image");
            sandwich.setImage(imageString);

            JSONArray ingredientsArray = jsonObject.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < ingredientsArray.length(); i++) {
                String ingredient = ingredientsArray.getString(i);
                ingredientsList.add(ingredient);
            }
            sandwich.setIngredients(ingredientsList);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }
}
