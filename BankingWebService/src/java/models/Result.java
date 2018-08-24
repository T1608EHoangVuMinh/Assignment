/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import service.History;

/**
 *
 * @author hoangminhk4b
 */
public class Result {
    String result;
    History history;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
}
