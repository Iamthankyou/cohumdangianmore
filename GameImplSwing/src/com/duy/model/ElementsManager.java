package com.duy.model;

import com.duy.entity.Element;
import com.duy.entity.Elements;
import com.duy.entity.Point;
import com.duy.utils.Observable;
import com.duy.entity.*;

public class ElementsManager extends Observable{
	private static ElementsManager uniqueInstance= null;
	private Elements elements;
	
	public static ElementsManager getInstance() {
		if (uniqueInstance==null) {
			uniqueInstance = new ElementsManager();
		}
		return uniqueInstance;
	}
	
	private ElementsManager() {
		elements = new Elements();
	}
	
	public void resetInstance() {
		uniqueInstance = null;
	}
	
	public void undo() {
		elements.undo();
		notifier();
	}
	
	public void redo() {
		elements.redo();
		notifier();
	}
	
    public void move(Point x, Point y) {
		elements.move(x, y);
		Element[][] map = elements.getMap();
		
		notifier();
	}

	public void updateMap(Point x, Element e) {
		elements.updateMap(x, e);
	}

	public Element getElement(Point x) {
		return elements.getElement(x);
	}
	
	public int isGameOver() {
		Element[][] map = elements.getMap();
		boolean free1 = true,free2 = true, free3=true;
		
		for (Element[] arr:map) {
			for (Element e:arr) {
				if (e instanceof Hum) {
					System.out.println("==> isHum");
					if (e.movesPossible(elements.getMap()).size()==0) {
						System.out.println("==> ok");
						if (free1==true) {
							free1 = false;
						}
						else if (free2==true) {
							free2 = false;
						}
						else if (free3==true) {
							free3 = false;
						}
					}
				}
			}
		}
		
		if (!free1 && !free2 && !free3) {
			return 1;
		}
		
		return elements.isGameOver();
	}
	
	public Elements getElements() {
		return elements;
	}
	
	
	public Element[][] getMap() {
		return elements.getMap();
	}

	public void setMap(Element[][] map) {
		elements.setMap(map);
		notifier();
	}
	
}
