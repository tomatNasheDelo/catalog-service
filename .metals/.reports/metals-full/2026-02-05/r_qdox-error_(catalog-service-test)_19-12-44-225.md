error id: jar:file://<HOME>/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/7.0.3/f84fd02ea33c0b6cab779ce66a218b5f8b79a9dc/spring-context-7.0.3-sources.jar!/org/springframework/context/MessageSourceResolvable.java
jar:file://<HOME>/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/7.0.3/f84fd02ea33c0b6cab779ce66a218b5f8b79a9dc/spring-context-7.0.3-sources.jar!/org/springframework/context/MessageSourceResolvable.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[40,9]

error in qdox parser
file content:
```java
offset: 1402
uri: jar:file://<HOME>/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/7.0.3/f84fd02ea33c0b6cab779ce66a218b5f8b79a9dc/spring-context-7.0.3-sources.jar!/org/springframework/context/MessageSourceResolvable.java
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

package org.springframework.context;

import org.jspecify.annotations.Nullable;

/**
 * Interface for objects that are suitable for message resolution in a
 * {@link MessageSource}.
 *
 * <p>Spring's own validation error classes implement this interface.
 *
 * @author Juergen Hoeller
 * @see MessageSource#getMessage(MessageSourceResolvable, java.util.Locale)
 * @see org.springframework.validation.ObjectError
 * @see org.springframework.validation.FieldError
 */
@FunctionalInterface
public interface MessageSourceResolvable {

	/**
	 * Return the codes to be used to resolve this message, in the order that
	 * they should get tried. The last code will therefore be the default one.
	 * @return a String array of codes which are associated with this message
	 */
	String @@@Nullable [] getCodes();

	/**
	 * Return the array of arguments to be used to resolve this message.
	 * <p>The default implementation simply returns {@code null}.
	 * @return an array of objects to be used as parameters to replace
	 * placeholders within the message text
	 * @see java.text.MessageFormat
	 */
	default Object @Nullable [] getArguments() {
		return null;
	}

	/**
	 * Return the default message to be used to resolve this message.
	 * <p>The default implementation simply returns {@code null}.
	 * Note that the default message may be identical to the primary
	 * message code ({@link #getCodes()}), which effectively enforces
	 * {@link org.springframework.context.support.AbstractMessageSource#setUseCodeAsDefaultMessage}
	 * for this particular message.
	 * @return the default message, or {@code null} if no default
	 */
	default @Nullable String getDefaultMessage() {
		return null;
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
	scala.meta.internal.metals.Docstrings.$anonfun$parentDocumentation$2(Docstrings.scala:87)
	scala.Option.orElse(Option.scala:477)
	scala.meta.internal.metals.Docstrings.$anonfun$parentDocumentation$1(Docstrings.scala:86)
	scala.collection.StrictOptimizedIterableOps.flatMap(StrictOptimizedIterableOps.scala:118)
	scala.collection.StrictOptimizedIterableOps.flatMap$(StrictOptimizedIterableOps.scala:105)
	scala.collection.convert.JavaCollectionWrappers$JListWrapper.flatMap(JavaCollectionWrappers.scala:138)
	scala.meta.internal.metals.Docstrings.parentDocumentation(Docstrings.scala:85)
	scala.meta.internal.metals.Docstrings.documentation(Docstrings.scala:68)
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

QDox parse error in /org/springframework/context/MessageSourceResolvable.java