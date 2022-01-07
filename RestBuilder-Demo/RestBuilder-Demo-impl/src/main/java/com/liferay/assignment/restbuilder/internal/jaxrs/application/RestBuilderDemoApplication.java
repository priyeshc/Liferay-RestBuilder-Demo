package com.liferay.assignment.restbuilder.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Argil DX
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/RestBuilder-Demo",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=RestBuilderDemo"
	},
	service = Application.class
)
@Generated("")
public class RestBuilderDemoApplication extends Application {
}