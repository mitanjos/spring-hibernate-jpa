package org.springframework.recommendations;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class RecommendationsNamespaceHandler extends NamespaceHandlerSupport{

	public void init() {
		System.out.println("Initializing handler");
		registerBeanDefinitionParser("user-based-recommender",new UserBasedRecommenderBeanDefinitionParser());
	}

}
