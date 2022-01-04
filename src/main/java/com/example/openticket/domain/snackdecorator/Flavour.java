package com.example.openticket.domain.snackdecorator;

public class Flavour extends AbstractAddOnDecorator{
    private AbstractSnackAndDrinks abstractSnackAndDrinks;
    public Flavour(AbstractSnackAndDrinks abstractSnackAndDrinks){
        this.abstractSnackAndDrinks = abstractSnackAndDrinks;
    }
    @Override
    public float cost() {
        return 0 + this.abstractSnackAndDrinks.cost();
    }
}
