error id: jar:file://<HOME>/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/7.0.3/f84fd02ea33c0b6cab779ce66a218b5f8b79a9dc/spring-context-7.0.3-sources.jar!/org/springframework/validation/FieldError.java
jar:file://<HOME>/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/7.0.3/f84fd02ea33c0b6cab779ce66a218b5f8b79a9dc/spring-context-7.0.3-sources.jar!/org/springframework/validation/FieldError.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[68,11]

error in qdox parser
file content:
```java
offset: 2396
uri: jar:file://<HOME>/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/7.0.3/f84fd02ea33c0b6cab779ce66a218b5f8b79a9dc/spring-context-7.0.3-sources.jar!/org/springframework/validation/FieldError.java
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

import org.jspecify.annotations.Nullable;

import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

/**
 * Encapsulates a field error, that is, a reason for rejecting a specific
 * field value.
 *
 * <p>See the {@link DefaultMessageCodesResolver} javadoc for details on
 * how a message code list is built for a {@code FieldError}.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @since 10.03.2003
 * @see DefaultMessageCodesResolver
 */
@SuppressWarnings("serial")
public class FieldError extends ObjectError {

	private final String field;

	private final @Nullable Object rejectedValue;

	private final boolean bindingFailure;


	/**
	 * Create a new FieldError instance.
	 * @param objectName the name of the affected object
	 * @param field the affected field of the object
	 * @param defaultMessage the default message to be used to resolve this message
	 */
	public FieldError(String objectName, String field, String defaultMessage) {
		this(objectName, field, null, false, null, null, defaultMessage);
	}

	/**
	 * Create a new FieldError instance.
	 * @param objectName the name of the affected object
	 * @param field the affected field of the object
	 * @param rejectedValue the rejected field value
	 * @param bindingFailure whether this error represents a binding failure
	 * (like a type mismatch); else, it is a validation failure
	 * @param codes the codes to be used to resolve this message
	 * @param arguments the array of arguments to be used to resolve this message
	 * @param defaultMessage the default message to be used to resolve this message
	 */
	public FieldError(String objectName, String field, @Nullable Object rejectedValue, boolean bindingFailure,
			String @@@Nullable [] codes, Object @Nullable [] arguments, @Nullable String defaultMessage) {

		super(objectName, codes, arguments, defaultMessage);
		Assert.notNull(field, "Field must not be null");
		this.field = field;
		this.rejectedValue = rejectedValue;
		this.bindingFailure = bindingFailure;
	}


	/**
	 * Return the affected field of the object.
	 */
	public String getField() {
		return this.field;
	}

	/**
	 * Return the rejected field value.
	 */
	public @Nullable Object getRejectedValue() {
		return this.rejectedValue;
	}

	/**
	 * Return whether this error represents a binding failure
	 * (like a type mismatch); otherwise it is a validation failure.
	 */
	public boolean isBindingFailure() {
		return this.bindingFailure;
	}


	@Override
	public boolean equals(@Nullable Object other) {
		if (this == other) {
			return true;
		}
		if (!super.equals(other)) {
			return false;
		}
		return (other instanceof FieldError otherError && getField().equals(otherError.getField()) &&
				ObjectUtils.nullSafeEquals(getRejectedValue(), otherError.getRejectedValue()) &&
				isBindingFailure() == otherError.isBindingFailure());
	}

	@Override
	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = 29 * hashCode + getField().hashCode();
		hashCode = 29 * hashCode + ObjectUtils.nullSafeHashCode(getRejectedValue());
		hashCode = 29 * hashCode + (isBindingFailure() ? 1 : 0);
		return hashCode;
	}

	@Override
	public String toString() {
		// We would preferably use ObjectUtils.nullSafeConciseToString(rejectedValue) here but
		// keep including the full nullSafeToString representation for backwards compatibility.
		return "Field error in object '" + getObjectName() + "' on field '" + this.field +
				"': rejected value [" + ObjectUtils.nullSafeToString(this.rejectedValue) + "]; " +
				resolvableToString();
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
	scala.meta.internal.pc.JavaHoverProvider.$anonfun$hoverOffset$1(JavaHoverProvider.scala:67)
	scala.Option.map(Option.scala:242)
	scala.meta.internal.pc.JavaHoverProvider.hoverOffset(JavaHoverProvider.scala:57)
	scala.meta.internal.pc.JavaHoverProvider.hover(JavaHoverProvider.scala:37)
	scala.meta.internal.pc.JavaPresentationCompiler.hover(JavaPresentationCompiler.scala:80)
	scala.meta.internal.metals.Compilers.$anonfun$hover$1(Compilers.scala:1041)
	scala.meta.internal.metals.Compilers.$anonfun$withPCAndAdjustLsp$12(Compilers.scala:1531)
	scala.Option.map(Option.scala:242)
	scala.meta.internal.metals.Compilers.$anonfun$withPCAndAdjustLsp$10(Compilers.scala:1531)
	scala.Option.flatMap(Option.scala:283)
	scala.meta.internal.metals.Compilers.withPCAndAdjustLsp(Compilers.scala:1513)
	scala.meta.internal.metals.Compilers.hover(Compilers.scala:1036)
	scala.meta.internal.metals.MetalsLspService.$anonfun$hover$1(MetalsLspService.scala:981)
	scala.meta.internal.metals.CancelTokens$.future(CancelTokens.scala:38)
	scala.meta.internal.metals.MetalsLspService.hover(MetalsLspService.scala:979)
	scala.meta.internal.metals.WorkspaceLspService.hover(WorkspaceLspService.scala:524)
	scala.meta.metals.lsp.DelegatingScalaService.hover(DelegatingScalaService.scala:78)
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

QDox parse error in /org/springframework/validation/FieldError.java