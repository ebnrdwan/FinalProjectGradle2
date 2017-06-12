package com.example;

public class JokePoller {
    private static String joke = "hey it's a joke haha";

    public static String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
