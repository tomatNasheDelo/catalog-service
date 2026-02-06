error id: jar:file://<HOME>/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/7.0.3/f84fd02ea33c0b6cab779ce66a218b5f8b79a9dc/spring-context-7.0.3-sources.jar!/org/springframework/context/support/DefaultMessageSourceResolvable.java
jar:file://<HOME>/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/7.0.3/f84fd02ea33c0b6cab779ce66a218b5f8b79a9dc/spring-context-7.0.3-sources.jar!/org/springframework/context/support/DefaultMessageSourceResolvable.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[39,23]

error in qdox parser
file content:
```java
offset: 1435
uri: jar:file://<HOME>/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/7.0.3/f84fd02ea33c0b6cab779ce66a218b5f8b79a9dc/spring-context-7.0.3-sources.jar!/org/springframework/context/support/DefaultMessageSourceResolvable.java
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

package org.springframework.context.support;

import java.io.Serializable;

import org.jspecify.annotations.Nullable;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * Spring's default implementation of the {@link MessageSourceResolvable} interface.
 * Offers an easy way to store all the necessary values needed to resolve
 * a message via a {@link org.springframework.context.MessageSource}.
 *
 * @author Juergen Hoeller
 * @since 13.02.2004
 * @see org.springframework.context.MessageSource#getMessage(MessageSourceResolvable, java.util.Locale)
 */
@SuppressWarnings("serial")
public class DefaultMessageSourceResolvable implements MessageSourceResolvable, Serializable {

	private final String @@@Nullable [] codes;

	private final Object @Nullable [] arguments;

	private final @Nullable String defaultMessage;


	/**
	 * Create a new DefaultMessageSourceResolvable.
	 * @param code the code to be used to resolve this message
	 */
	public DefaultMessageSourceResolvable(String code) {
		this(new String[] {code}, null, null);
	}

	/**
	 * Create a new DefaultMessageSourceResolvable.
	 * @param codes the codes to be used to resolve this message
	 */
	public DefaultMessageSourceResolvable(String[] codes) {
		this(codes, null, null);
	}

	/**
	 * Create a new DefaultMessageSourceResolvable.
	 * @param codes the codes to be used to resolve this message
	 * @param defaultMessage the default message to be used to resolve this message
	 */
	public DefaultMessageSourceResolvable(String[] codes, String defaultMessage) {
		this(codes, null, defaultMessage);
	}

	/**
	 * Create a new DefaultMessageSourceResolvable.
	 * @param codes the codes to be used to resolve this message
	 * @param arguments the array of arguments to be used to resolve this message
	 */
	public DefaultMessageSourceResolvable(String[] codes, Object[] arguments) {
		this(codes, arguments, null);
	}

	/**
	 * Create a new DefaultMessageSourceResolvable.
	 * @param codes the codes to be used to resolve this message
	 * @param arguments the array of arguments to be used to resolve this message
	 * @param defaultMessage the default message to be used to resolve this message
	 */
	public DefaultMessageSourceResolvable(
			String @Nullable [] codes, Object @Nullable [] arguments, @Nullable String defaultMessage) {

		this.codes = codes;
		this.arguments = arguments;
		this.defaultMessage = defaultMessage;
	}

	/**
	 * Copy constructor: Create a new instance from another resolvable.
	 * @param resolvable the resolvable to copy from
	 */
	public DefaultMessageSourceResolvable(MessageSourceResolvable resolvable) {
		this(resolvable.getCodes(), resolvable.getArguments(), resolvable.getDefaultMessage());
	}


	/**
	 * Return the default code of this resolvable, that is,
	 * the last one in the codes array.
	 */
	public @Nullable String getCode() {
		return (this.codes != null && this.codes.length > 0 ? this.codes[this.codes.length - 1] : null);
	}

	@Override
	public String @Nullable [] getCodes() {
		return this.codes;
	}

	@Override
	public Object @Nullable [] getArguments() {
		return this.arguments;
	}

	@Override
	public @Nullable String getDefaultMessage() {
		return this.defaultMessage;
	}

	/**
	 * Indicate whether the specified default message needs to be rendered for
	 * substituting placeholders and/or {@link java.text.MessageFormat} escaping.
	 * @return {@code true} if the default message may contain argument placeholders;
	 * {@code false} if it definitely does not contain placeholders or custom escaping
	 * and can therefore be simply exposed as-is
	 * @since 5.1.7
	 * @see #getDefaultMessage()
	 * @see #getArguments()
	 * @see AbstractMessageSource#renderDefaultMessage
	 */
	public boolean shouldRenderDefaultMessage() {
		return true;
	}


	/**
	 * Build a default String representation for this MessageSourceResolvable:
	 * including codes, arguments, and default message.
	 */
	protected final String resolvableToString() {
		StringBuilder result = new StringBuilder(64);
		result.append("codes [").append(StringUtils.arrayToDelimitedString(this.codes, ","));
		result.append("]; arguments [").append(StringUtils.arrayToDelimitedString(this.arguments, ","));
		result.append("]; default message [").append(this.defaultMessage).append(']');
		return result.toString();
	}

	/**
	 * The default implementation exposes the attributes of this MessageSourceResolvable.
	 * <p>To be overridden in more specific subclasses, potentially including the
	 * resolvable content through {@code resolvableToString()}.
	 * @see #resolvableToString()
	 */
	@Override
	public String toString() {
		return getClass().getName() + ": " + resolvableToString();
	}


	@Override
	public boolean equals(@Nullable Object other) {
		return (this == other || (other instanceof MessageSourceResolvable that &&
				ObjectUtils.nullSafeEquals(getCodes(), that.getCodes()) &&
				ObjectUtils.nullSafeEquals(getArguments(), that.getArguments()) &&
				ObjectUtils.nullSafeEquals(getDefaultMessage(), that.getDefaultMessage())));
	}

	@Override
	public int hashCode() {
		return ObjectUtils.nullSafeHash(getCode(), getArguments(), getDefaultMessage());
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

QDox parse error in /org/springframework/context/support/DefaultMessageSourceResolvable.java