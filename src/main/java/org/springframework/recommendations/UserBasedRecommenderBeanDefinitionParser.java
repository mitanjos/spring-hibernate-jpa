package org.springframework.recommendations;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import java.util.ArrayList;

public class UserBasedRecommenderBeanDefinitionParser extends AbstractBeanDefinitionParser{

	@Override
	protected AbstractBeanDefinition parseInternal(Element element,
			ParserContext parserContext) {
		System.out.println("Inside handler");
		BeanDefinitionBuilder recommenderBeanBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayList.class);
        Element neighborhood = DomUtils.getChildElementsByTagName(element, "nearest-neighborhood").get(0);        
        Element model = DomUtils.getChildElementsByTagName(element, "file-model").get(0);
        String filePath = model.getAttribute("path");
        System.out.println(filePath);
        String neighborSize = neighborhood.getAttribute("size");
        System.out.println(neighborSize);
        
        
        return recommenderBeanBuilder.getBeanDefinition();
	}

}
