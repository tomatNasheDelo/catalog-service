error id: jar:file://<HOME>/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/7.0.3/f84fd02ea33c0b6cab779ce66a218b5f8b79a9dc/spring-context-7.0.3-sources.jar!/org/springframework/validation/Errors.java
jar:file://<HOME>/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/7.0.3/f84fd02ea33c0b6cab779ce66a218b5f8b79a9dc/spring-context-7.0.3-sources.jar!/org/springframework/validation/Errors.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[148,39]

error in qdox parser
file content:
```java
offset: 5527
uri: jar:file://<HOME>/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/7.0.3/f84fd02ea33c0b6cab779ce66a218b5f8b79a9dc/spring-context-7.0.3-sources.jar!/org/springframework/validation/Errors.java
text:
```scala
/*
 * Copyright 2002-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.validation;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import org.jspecify.annotations.Nullable;

import org.springframework.beans.PropertyAccessor;

/**
 * Stores and exposes information about data-binding and validation errors
 * for a specific object.
 *
 * <p>Field names are typically properties of the target object (for example, "name"
 * when binding to a customer object). Implementations may also support nested
 * fields in case of nested objects (for example, "address.street"), in conjunction
 * with subtree navigation via {@link #setNestedPath}: for example, an
 * {@code AddressValidator} may validate "address", not being aware that this
 * is a nested object of a top-level customer object.
 *
 * <p>Note: {@code Errors} objects are single-threaded.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see Validator
 * @see ValidationUtils
 * @see SimpleErrors
 * @see BindingResult
 */
public interface Errors {

	/**
	 * The separator between path elements in a nested path,
	 * for example in "customer.name" or "customer.address.street".
	 * <p>"." = same as the
	 * {@link org.springframework.beans.PropertyAccessor#NESTED_PROPERTY_SEPARATOR nested property separator}
	 * in the beans package.
	 */
	String NESTED_PATH_SEPARATOR = PropertyAccessor.NESTED_PROPERTY_SEPARATOR;


	/**
	 * Return the name of the bound root object.
	 */
	String getObjectName();

	/**
	 * Allow context to be changed so that standard validators can validate
	 * subtrees. Reject calls prepend the given path to the field names.
	 * <p>For example, an address validator could validate the subobject
	 * "address" of a customer object.
	 * <p>The default implementation throws {@code UnsupportedOperationException}
	 * since not all {@code Errors} implementations support nested paths.
	 * @param nestedPath nested path within this object,
	 * for example, "address" (defaults to "", {@code null} is also acceptable).
	 * Can end with a dot: both "address" and "address." are valid.
	 * @see #getNestedPath()
	 */
	default void setNestedPath(String nestedPath) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + " does not support nested paths");
	}

	/**
	 * Return the current nested path of this {@link Errors} object.
	 * <p>Returns a nested path with a dot, i.e. "address.", for easy
	 * building of concatenated paths. Default is an empty String.
	 * @see #setNestedPath(String)
	 */
	default String getNestedPath() {
		return "";
	}

	/**
	 * Push the given sub path onto the nested path stack.
	 * <p>A {@link #popNestedPath()} call will reset the original
	 * nested path before the corresponding
	 * {@code pushNestedPath(String)} call.
	 * <p>Using the nested path stack allows to set temporary nested paths
	 * for subobjects without having to worry about a temporary path holder.
	 * <p>For example: current path "spouse.", pushNestedPath("child") &rarr;
	 * result path "spouse.child."; popNestedPath() &rarr; "spouse." again.
	 * <p>The default implementation throws {@code UnsupportedOperationException}
	 * since not all {@code Errors} implementations support nested paths.
	 * @param subPath the sub path to push onto the nested path stack
	 * @see #popNestedPath()
	 */
	default void pushNestedPath(String subPath) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + " does not support nested paths");
	}

	/**
	 * Pop the former nested path from the nested path stack.
	 * @throws IllegalStateException if there is no former nested path on the stack
	 * @see #pushNestedPath(String)
	 */
	default void popNestedPath() throws IllegalStateException {
		throw new IllegalStateException("Cannot pop nested path: no nested path on stack");
	}

	/**
	 * Register a global error for the entire target object,
	 * using the given error description.
	 * @param errorCode error code, interpretable as a message key
	 * @see #reject(String, Object[], String)
	 */
	default void reject(String errorCode) {
		reject(errorCode, null, null);
	}

	/**
	 * Register a global error for the entire target object,
	 * using the given error description.
	 * @param errorCode error code, interpretable as a message key
	 * @param defaultMessage fallback default message
	 * @see #reject(String, Object[], String)
	 */
	default void reject(String errorCode, String defaultMessage) {
		reject(errorCode, null, defaultMessage);
	}

	/**
	 * Register a global error for the entire target object,
	 * using the given error description.
	 * @param errorCode error code, interpretable as a message key
	 * @param errorArgs error arguments, for argument binding via MessageFormat
	 * (can be {@code null})
	 * @param defaultMessage fallback default message
	 * @see #rejectValue(String, String, Object[], String)
	 */
	void reject(String errorCode, Object @@@Nullable [] errorArgs, @Nullable String defaultMessage);

	/**
	 * Register a field error for the specified field of the current object
	 * (respecting the current nested path, if any), using the given error
	 * description.
	 * <p>The field name may be {@code null} or empty String to indicate
	 * the current object itself rather than a field of it. This may result
	 * in a corresponding field error within the nested object graph or a
	 * global error if the current object is the top object.
	 * @param field the field name (may be {@code null} or empty String)
	 * @param errorCode error code, interpretable as a message key
	 * @see #rejectValue(String, String, Object[], String)
	 */
	default void rejectValue(@Nullable String field, String errorCode) {
		rejectValue(field, errorCode, null, null);
	}

	/**
	 * Register a field error for the specified field of the current object
	 * (respecting the current nested path, if any), using the given error
	 * description.
	 * <p>The field name may be {@code null} or empty String to indicate
	 * the current object itself rather than a field of it. This may result
	 * in a corresponding field error within the nested object graph or a
	 * global error if the current object is the top object.
	 * @param field the field name (may be {@code null} or empty String)
	 * @param errorCode error code, interpretable as a message key
	 * @param defaultMessage fallback default message
	 * @see #rejectValue(String, String, Object[], String)
	 */
	default void rejectValue(@Nullable String field, String errorCode, String defaultMessage) {
		rejectValue(field, errorCode, null, defaultMessage);
	}

	/**
	 * Register a field error for the specified field of the current object
	 * (respecting the current nested path, if any), using the given error
	 * description.
	 * <p>The field name may be {@code null} or empty String to indicate
	 * the current object itself rather than a field of it. This may result
	 * in a corresponding field error within the nested object graph or a
	 * global error if the current object is the top object.
	 * @param field the field name (may be {@code null} or empty String)
	 * @param errorCode error code, interpretable as a message key
	 * @param errorArgs error arguments, for argument binding via MessageFormat
	 * (can be {@code null})
	 * @param defaultMessage fallback default message
	 * @see #reject(String, Object[], String)
	 */
	void rejectValue(@Nullable String field, String errorCode,
			Object @Nullable [] errorArgs, @Nullable String defaultMessage);

	/**
	 * Add all errors from the given {@code Errors} instance to this
	 * {@code Errors} instance.
	 * <p>This is a convenience method to avoid repeated {@code reject(..)}
	 * calls for merging an {@code Errors} instance into another
	 * {@code Errors} instance.
	 * <p>Note that the passed-in {@code Errors} instance is supposed
	 * to refer to the same target object, or at least contain compatible errors
	 * that apply to the target object of this {@code Errors} instance.
	 * <p>The default implementation throws {@code UnsupportedOperationException}
	 * since not all {@code Errors} implementations support {@code #addAllErrors}.
	 * @param errors the {@code Errors} instance to merge in
	 * @see #getAllErrors()
	 */
	default void addAllErrors(Errors errors) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + " does not support addAllErrors");
	}

	/**
	 * Throw the mapped exception with a message summarizing the recorded errors.
	 * @param messageToException a function mapping the message to the exception,
	 * for example, {@code IllegalArgumentException::new} or {@code IllegalStateException::new}
	 * @param <T> the exception type to be thrown
	 * @since 6.1
	 * @see #toString()
	 */
	default <T extends Throwable> void failOnError(Function<String, T> messageToException) throws T {
		if (hasErrors()) {
			throw messageToException.apply(toString());
		}
	}

	/**
	 * Determine if there were any errors.
	 * @see #hasGlobalErrors()
	 * @see #hasFieldErrors()
	 */
	default boolean hasErrors() {
		return (!getGlobalErrors().isEmpty() || !getFieldErrors().isEmpty());
	}

	/**
	 * Determine the total number of errors.
	 * @see #getGlobalErrorCount()
	 * @see #getFieldErrorCount()
	 */
	default int getErrorCount() {
		return (getGlobalErrors().size() + getFieldErrors().size());
	}

	/**
	 * Get all errors, both global and field ones.
	 * @return a list of {@link ObjectError}/{@link FieldError} instances
	 * @see #getGlobalErrors()
	 * @see #getFieldErrors()
	 */
	default List<ObjectError> getAllErrors() {
		return Stream.concat(getGlobalErrors().stream(), getFieldErrors().stream()).toList();
	}

	/**
	 * Determine if there were any global errors.
	 * @see #hasFieldErrors()
	 */
	default boolean hasGlobalErrors() {
		return !getGlobalErrors().isEmpty();
	}

	/**
	 * Determine the number of global errors.
	 * @see #getFieldErrorCount()
	 */
	default int getGlobalErrorCount() {
		return getGlobalErrors().size();
	}

	/**
	 * Get all global errors.
	 * @return a list of {@link ObjectError} instances
	 * @see #getFieldErrors()
	 */
	List<ObjectError> getGlobalErrors();

	/**
	 * Get the <i>first</i> global error, if any.
	 * @return the global error, or {@code null}
	 * @see #getFieldError()
	 */
	default @Nullable ObjectError getGlobalError() {
		return getGlobalErrors().stream().findFirst().orElse(null);
	}

	/**
	 * Determine if there were any errors associated with a field.
	 * @see #hasGlobalErrors()
	 */
	default boolean hasFieldErrors() {
		return !getFieldErrors().isEmpty();
	}

	/**
	 * Determine the number of errors associated with a field.
	 * @see #getGlobalErrorCount()
	 */
	default int getFieldErrorCount() {
		return getFieldErrors().size();
	}

	/**
	 * Get all errors associated with a field.
	 * @return a List of {@link FieldError} instances
	 * @see #getGlobalErrors()
	 */
	List<FieldError> getFieldErrors();

	/**
	 * Get the <i>first</i> error associated with a field, if any.
	 * @return the field-specific error, or {@code null}
	 * @see #getGlobalError()
	 */
	default @Nullable FieldError getFieldError() {
		return getFieldErrors().stream().findFirst().orElse(null);
	}

	/**
	 * Determine if there were any errors associated with the given field.
	 * @param field the field name
	 * @see #hasFieldErrors()
	 */
	default boolean hasFieldErrors(String field) {
		return (getFieldError(field) != null);
	}

	/**
	 * Determine the number of errors associated with the given field.
	 * @param field the field name
	 * @see #getFieldErrorCount()
	 */
	default int getFieldErrorCount(String field) {
		return getFieldErrors(field).size();
	}

	/**
	 * Get all errors associated with the given field.
	 * <p>Implementations may support not only full field names like
	 * "address.street" but also pattern matches like "address.*".
	 * @param field the field name
	 * @return a List of {@link FieldError} instances
	 * @see #getFieldErrors()
	 */
	default List<FieldError> getFieldErrors(String field) {
		return getFieldErrors().stream().filter(error -> field.equals(error.getField())).toList();
	}

	/**
	 * Get the first error associated with the given field, if any.
	 * @param field the field name
	 * @return the field-specific error, or {@code null}
	 * @see #getFieldError()
	 */
	default @Nullable FieldError getFieldError(String field) {
		return getFieldErrors().stream().filter(error -> field.equals(error.getField())).findFirst().orElse(null);
	}

	/**
	 * Return the current value of the given field, either the current
	 * bean property value or a rejected update from the last binding.
	 * <p>Allows for convenient access to user-specified field values,
	 * even if there were type mismatches.
	 * @param field the field name
	 * @return the current value of the given field
	 * @see #getFieldType(String)
	 */
	@Nullable Object getFieldValue(String field);

	/**
	 * Determine the type of the given field, as far as possible.
	 * <p>Implementations should be able to determine the type even
	 * when the field value is {@code null}, for example from some
	 * associated descriptor.
	 * @param field the field name
	 * @return the type of the field, or {@code null} if not determinable
	 * @see #getFieldValue(String)
	 */
	default @Nullable Class<?> getFieldType(String field) {
		return Optional.ofNullable(getFieldValue(field)).map(Object::getClass).orElse(null);
	}

	/**
	 * Return a summary of the recorded errors,
	 * for example, for inclusion in an exception message.
	 * @see #failOnError(Function)
	 */
	@Override
	String toString();

}

```

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.mtags.MtagsIndexer.index(MtagsIndexer.scala:22)
	scala.meta.internal.mtags.MtagsIndexer.index$(MtagsIndexer.scala:21)
	scala.meta.internal.mtags.JavaMtags.index(JavaMtags.scala:39)
	scala.meta.internal.mtags.Mtags.index(Mtags.scala:106)
	scala.meta.internal.mtags.Mtags.allSymbols(Mtags.scala:21)
	scala.meta.internal.mtags.SymbolIndexBucket.allSymbols(SymbolIndexBucket.scala:293)
	scala.meta.internal.mtags.SymbolIndexBucket.addMtagsSourceFile(SymbolIndexBucket.scala:304)
	scala.meta.internal.mtags.SymbolIndexBucket.$anonfun$query0$1(SymbolIndexBucket.scala:220)
	scala.meta.internal.mtags.SymbolIndexBucket.$anonfun$query0$1$adapted(SymbolIndexBucket.scala:220)
	scala.collection.immutable.Set$Set1.foreach(Set.scala:177)
	scala.meta.internal.mtags.SymbolIndexBucket.query0(SymbolIndexBucket.scala:220)
	scala.meta.internal.mtags.SymbolIndexBucket.query(SymbolIndexBucket.scala:193)
	scala.meta.internal.mtags.OnDemandSymbolIndex.$anonfun$findSymbolDefinition$1(OnDemandSymbolIndex.scala:143)
	scala.collection.immutable.List.flatMap(List.scala:283)
	scala.meta.internal.mtags.OnDemandSymbolIndex.findSymbolDefinition(OnDemandSymbolIndex.scala:143)
	scala.meta.internal.mtags.OnDemandSymbolIndex.definition(OnDemandSymbolIndex.scala:48)
	scala.meta.internal.metals.Docstrings.indexSymbol(Docstrings.scala:138)
	scala.meta.internal.metals.Docstrings.documentation(Docstrings.scala:49)
	scala.meta.internal.metals.MetalsSymbolSearch.documentation(MetalsSymbolSearch.scala:47)
	scala.meta.internal.pc.JavaMetalsGlobal.documentation(JavaMetalsGlobal.scala:187)
	scala.meta.internal.pc.JavaSignatureHelpProvider.scala$meta$internal$pc$JavaSignatureHelpProvider$$createExecutableSignature(JavaSignatureHelpProvider.scala:214)
	scala.meta.internal.pc.JavaSignatureHelpProvider.createSignatureHelp(JavaSignatureHelpProvider.scala:160)
	scala.meta.internal.pc.JavaSignatureHelpProvider.signatureHelp(JavaSignatureHelpProvider.scala:44)
	scala.meta.internal.pc.JavaPresentationCompiler.signatureHelp(JavaPresentationCompiler.scala:72)
	scala.meta.internal.metals.Compilers.$anonfun$signatureHelp$1(Compilers.scala:1173)
	scala.meta.internal.metals.Compilers.$anonfun$withPCAndAdjustLsp$4(Compilers.scala:1446)
	scala.Option.map(Option.scala:242)
	scala.meta.internal.metals.Compilers.$anonfun$withPCAndAdjustLsp$3(Compilers.scala:1446)
	scala.Option.flatMap(Option.scala:283)
	scala.meta.internal.metals.Compilers.withPCAndAdjustLsp(Compilers.scala:1438)
	scala.meta.internal.metals.Compilers.signatureHelp(Compilers.scala:1168)
	scala.meta.internal.metals.MetalsLspService.$anonfun$signatureHelp$1(MetalsLspService.scala:1206)
	scala.meta.internal.metals.CancelTokens$.future(CancelTokens.scala:38)
	scala.meta.internal.metals.MetalsLspService.signatureHelp(MetalsLspService.scala:1205)
	scala.meta.internal.metals.WorkspaceLspService.signatureHelp(WorkspaceLspService.scala:621)
	scala.meta.metals.lsp.DelegatingScalaService.signatureHelp(DelegatingScalaService.scala:153)
	java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	java.base/java.lang.reflect.Method.invoke(Method.java:580)
	org.eclipse.lsp4j.jsonrpc.services.GenericEndpoint.lambda$recursiveFindRpcMethods$0(GenericEndpoint.java:65)
	org.eclipse.lsp4j.jsonrpc.services.GenericEndpoint.request(GenericEndpoint.java:128)
	org.eclipse.lsp4j.jsonrpc.RemoteEndpoint.handleRequest(RemoteEndpoint.java:271)
	org.eclipse.lsp4j.jsonrpc.RemoteEndpoint.consume(RemoteEndpoint.java:201)
	org.eclipse.lsp4j.jsonrpc.json.StreamMessageProducer.handleMessage(StreamMessageProducer.java:185)
	org.eclipse.lsp4j.jsonrpc.json.StreamMessageProducer.listen(StreamMessageProducer.java:97)
	org.eclipse.lsp4j.jsonrpc.json.ConcurrentMessageProcessor.run(ConcurrentMessageProcessor.java:114)
	java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:572)
	java.base/java.util.concurrent.FutureTask.run(FutureTask.java:317)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	java.base/java.lang.Thread.run(Thread.java:1583)
```
#### Short summary: 

QDox parse error in /org/springframework/validation/Errors.java