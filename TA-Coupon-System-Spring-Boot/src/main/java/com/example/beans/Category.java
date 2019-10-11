package com.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public enum Category {
	Food, Electricity, Restaurant, Vacation;
	
}
