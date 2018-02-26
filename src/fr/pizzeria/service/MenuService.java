package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.controleur.IPizzaDao;

public abstract class MenuService {
	public abstract void executeUC(IPizzaDao lesPizzas, Scanner questionUser);
}
