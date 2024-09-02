/**
 * 
 */
/**
 * 
 */
module Widget {
	requires java.desktop;
	requires java.net.http;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.annotation;
	opens entity to com.fasterxml.jackson.databind;
}
