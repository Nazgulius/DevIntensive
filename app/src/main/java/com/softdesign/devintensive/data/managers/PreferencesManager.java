package com.softdesign.devintensive.data.managers;

import android.content.SharedPreferences;
import android.net.Uri;

import com.softdesign.devintensive.utils.ConstantManager;
import com.softdesign.devintensive.utils.DevintensiveApplication;

import java.util.ArrayList;
import java.util.List;

public class PreferencesManager {

    private SharedPreferences mSharedPreferences;
    private static final String[] USER_FILES = {
            ConstantManager.USER_PHONE_KEY,
            ConstantManager.USER_MAIL_KEY,
            ConstantManager.USER_VK_KEY,
            ConstantManager.USER_GIT_KEY,
            ConstantManager.USER_BIO_KEY
    };

    private static final String[] USER_VALUES = {
            ConstantManager.USER_RATING_VALUE,
            ConstantManager.USER_CODE_LINES_VALUE,
            ConstantManager.USER_PROJECT_VALUE,
    };


    public PreferencesManager() {
        this.mSharedPreferences = DevintensiveApplication.getSharedPreferencec();
    }

    public void saveUserProfileData(List<String> userFields) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        for (int i = 0; i < USER_FILES.length; i++) {
            editor.putString(USER_FILES[i], userFields.get(i));
        }
        editor.apply();
    }

    public List<String> loadUserProfileData() {
        List<String> userFields = new ArrayList<>();
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_PHONE_KEY, "null"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_MAIL_KEY, "null"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_VK_KEY, "null"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_GIT_KEY, ConstantManager.FIRST_FIELD_GIT));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_BIO_KEY, ConstantManager.FIRST_FIELD_ABOUT));
        return userFields;
    }

    // изменено с saveUserProfileData
    public void saveUserPhoto(Uri uri) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.USER_PHOTO_KEY, uri.toString());
        editor.apply();
    }

    public void saveAvatarImage(Uri uri) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.USER_AVATAR_KEY, uri.toString());
        editor.apply();
    }

    public Uri loadUserPhoto() {
        return Uri.parse(mSharedPreferences.getString(ConstantManager.USER_PHOTO_KEY,
                ConstantManager.FIRST_USER_PHOTO));
    }

    public Uri loadAvatarImage() {
        return Uri.parse(mSharedPreferences.getString(ConstantManager.USER_AVATAR_KEY,
                ConstantManager.FIRST_IMAGE_AVATAR));
    }

    public List<String> loadUserProfileValues() {
        List<String> userValues = new ArrayList<>();
        userValues.add(mSharedPreferences.getString(ConstantManager.USER_RATING_VALUE, "0"));
        userValues.add(mSharedPreferences.getString(ConstantManager.USER_CODE_LINES_VALUE, "0"));
        userValues.add(mSharedPreferences.getString(ConstantManager.USER_PROJECT_VALUE, "0"));
        return userValues;
    }



    public void saveAuthToken(String authToken) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.AUTH_TOKEN_KEY, authToken);
        editor.apply();
    }

    public String getAuthToken() {
        return mSharedPreferences.getString(ConstantManager.AUTH_TOKEN_KEY, "null");
    }

    public void saveUserId(String userId) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.USER_ID_KEY, userId);
        editor.apply();
    }

    public String getUserId() {
        return mSharedPreferences.getString(ConstantManager.USER_ID_KEY, "null");
    }

    public void saveUserProfileValues(int[] userValue) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        for (int i = 0; i < USER_VALUES.length; i++) {
            editor.putString(USER_VALUES[i], String.valueOf(userValue[i]));
        }
        editor.apply();
    }

    public void saveFirstSecondNameUser(String firstName, String secondName) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.USER_FIRST_NAME_KEY, firstName);
        editor.putString(ConstantManager.USER_SECOND_NAME_KEY, secondName);
        editor.apply();
    }

    public List<String> loadFirstSecondNameUser() {
        List<String> list = new ArrayList<>();
        list.add(mSharedPreferences.getString(ConstantManager.USER_FIRST_NAME_KEY, "null"));
        list.add(mSharedPreferences.getString(ConstantManager.USER_SECOND_NAME_KEY, "null"));
        return list;
    }
}
