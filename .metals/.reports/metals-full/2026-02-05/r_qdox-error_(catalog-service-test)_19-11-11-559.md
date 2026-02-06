error id: jar:file://<HOME>/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/7.0.3/f84fd02ea33c0b6cab779ce66a218b5f8b79a9dc/spring-context-7.0.3-sources.jar!/org/springframework/validation/BindException.java
jar:file://<HOME>/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/7.0.3/f84fd02ea33c0b6cab779ce66a218b5f8b79a9dc/spring-context-7.0.3-sources.jar!/org/springframework/validation/BindException.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[117,46]

error in qdox parser
file content:
```java
offset: 3341
uri: jar:file://<HOME>/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/7.0.3/f84fd02ea33c0b6cab779ce66a218b5f8b79a9dc/spring-context-7.0.3-sources.jar!/org/springframework/validation/BindException.java
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

import java.beans.PropertyEditor;
import java.util.List;
import java.util.Map;

import org.jspecify.annotations.Nullable;

import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.util.Assert;

/**
 * Thrown when binding errors are considered fatal. Implements the
 * {@link BindingResult} interface (and its super-interface {@link Errors})
 * to allow for the direct analysis of binding errors.
 *
 * <p>As of Spring 2.0, this is a special-purpose class. Normally,
 * application code will work with the {@link BindingResult} interface,
 * or with a {@link DataBinder} that in turn exposes a BindingResult via
 * {@link org.springframework.validation.DataBinder#getBindingResult()}.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @see BindingResult
 * @see DataBinder#getBindingResult()
 * @see DataBinder#close()
 */
@SuppressWarnings("serial")
public class BindException extends Exception implements BindingResult {

	private final BindingResult bindingResult;


	/**
	 * Create a new BindException instance for a BindingResult.
	 * @param bindingResult the BindingResult instance to wrap
	 */
	public BindException(BindingResult bindingResult) {
		Assert.notNull(bindingResult, "BindingResult must not be null");
		this.bindingResult = bindingResult;
	}

	/**
	 * Create a new BindException instance for a target bean.
	 * @param target the target bean to bind onto
	 * @param objectName the name of the target object
	 * @see BeanPropertyBindingResult
	 */
	public BindException(Object target, String objectName) {
		Assert.notNull(target, "Target object must not be null");
		this.bindingResult = new BeanPropertyBindingResult(target, objectName);
	}


	/**
	 * Return the BindingResult that this BindException wraps.
	 */
	public final BindingResult getBindingResult() {
		return this.bindingResult;
	}


	@Override
	public String getObjectName() {
		return this.bindingResult.getObjectName();
	}

	@Override
	public void setNestedPath(String nestedPath) {
		this.bindingResult.setNestedPath(nestedPath);
	}

	@Override
	public String getNestedPath() {
		return this.bindingResult.getNestedPath();
	}

	@Override
	public void pushNestedPath(String subPath) {
		this.bindingResult.pushNestedPath(subPath);
	}

	@Override
	public void popNestedPath() throws IllegalStateException {
		this.bindingResult.popNestedPath();
	}


	@Override
	public void reject(String errorCode) {
		this.bindingResult.reject(errorCode);
	}

	@Override
	public void reject(String errorCode, String defaultMessage) {
		this.bindingResult.reject(errorCode, defaultMessage);
	}

	@Override
	public void reject(String errorCode, Object @@@Nullable [] errorArgs, @Nullable String defaultMessage) {
		this.bindingResult.reject(errorCode, errorArgs, defaultMessage);
	}

	@Override
	public void rejectValue(@Nullable String field, String errorCode) {
		this.bindingResult.rejectValue(field, errorCode);
	}

	@Override
	public void rejectValue(@Nullable String field, String errorCode, String defaultMessage) {
		this.bindingResult.rejectValue(field, errorCode, defaultMessage);
	}

	@Override
	public void rejectValue(@Nullable String field, String errorCode,
			Object @Nullable [] errorArgs, @Nullable String defaultMessage) {

		this.bindingResult.rejectValue(field, errorCode, errorArgs, defaultMessage);
	}

	@Override
	public void addAllErrors(Errors errors) {
		this.bindingResult.addAllErrors(errors);
	}


	@Override
	public boolean hasErrors() {
		return this.bindingResult.hasErrors();
	}

	@Override
	public int getErrorCount() {
		return this.bindingResult.getErrorCount();
	}

	@Override
	public List<ObjectError> getAllErrors() {
		return this.bindingResult.getAllErrors();
	}

	@Override
	public boolean hasGlobalErrors() {
		return this.bindingResult.hasGlobalErrors();
	}

	@Override
	public int getGlobalErrorCount() {
		return this.bindingResult.getGlobalErrorCount();
	}

	@Override
	public List<ObjectError> getGlobalErrors() {
		return this.bindingResult.getGlobalErrors();
	}

	@Override
	public @Nullable ObjectError getGlobalError() {
		return this.bindingResult.getGlobalError();
	}

	@Override
	public boolean hasFieldErrors() {
		return this.bindingResult.hasFieldErrors();
	}

	@Override
	public int getFieldErrorCount() {
		return this.bindingResult.getFieldErrorCount();
	}

	@Override
	public List<FieldError> getFieldErrors() {
		return this.bindingResult.getFieldErrors();
	}

	@Override
	public @Nullable FieldError getFieldError() {
		return this.bindingResult.getFieldError();
	}

	@Override
	public boolean hasFieldErrors(String field) {
		return this.bindingResult.hasFieldErrors(field);
	}

	@Override
	public int getFieldErrorCount(String field) {
		return this.bindingResult.getFieldErrorCount(field);
	}

	@Override
	public List<FieldError> getFieldErrors(String field) {
		return this.bindingResult.getFieldErrors(field);
	}

	@Override
	public @Nullable FieldError getFieldError(String field) {
		return this.bindingResult.getFieldError(field);
	}

	@Override
	public @Nullable Object getFieldValue(String field) {
		return this.bindingResult.getFieldValue(field);
	}

	@Override
	public @Nullable Class<?> getFieldType(String field) {
		return this.bindingResult.getFieldType(field);
	}

	@Override
	public @Nullable Object getTarget() {
		return this.bindingResult.getTarget();
	}

	@Override
	public Map<String, Object> getModel() {
		return this.bindingResult.getModel();
	}

	@Override
	public @Nullable Object getRawFieldValue(String field) {
		return this.bindingResult.getRawFieldValue(field);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public @Nullable PropertyEditor findEditor(@Nullable String field, @Nullable Class valueType) {
		return this.bindingResult.findEditor(field, valueType);
	}

	@Override
	public @Nullable PropertyEditorRegistry getPropertyEditorRegistry() {
		return this.bindingResult.getPropertyEditorRegistry();
	}

	@Override
	public String[] resolveMessageCodes(String errorCode) {
		return this.bindingResult.resolveMessageCodes(errorCode);
	}

	@Override
	public String[] resolveMessageCodes(String errorCode, String field) {
		return this.bindingResult.resolveMessageCodes(errorCode, field);
	}

	@Override
	public void addError(ObjectError error) {
		this.bindingResult.addError(error);
	}

	@Override
	public void recordFieldValue(String field, Class<?> type, @Nullable Object value) {
		this.bindingResult.recordFieldValue(field, type, value);
	}

	@Override
	public void recordSuppressedField(String field) {
		this.bindingResult.recordSuppressedField(field);
	}

	@Override
	public String[] getSuppressedFields() {
		return this.bindingResult.getSuppressedFields();
	}


	/**
	 * Returns diagnostic information about the errors held in this object.
	 */
	@Override
	public String getMessage() {
		return this.bindingResult.toString();
	}

	@Override
	public boolean equals(@Nullable Object other) {
		return (this == other || this.bindingResult.equals(other));
	}

	@Override
	public int hashCode() {
		return this.bindingResult.hashCode();
	}

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

QDox parse error in /org/springframework/validation/BindException.java