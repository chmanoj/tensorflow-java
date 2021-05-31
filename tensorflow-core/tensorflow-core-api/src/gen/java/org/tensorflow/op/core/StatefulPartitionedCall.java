/* Copyright 2018 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
=======================================================================*/

// This class has been generated, DO NOT EDIT!

package org.tensorflow.op.core;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.tensorflow.ConcreteFunction;
import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.op.Operands;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.types.family.TType;

/**
 * returns {@code f(inputs)}, where {@code f}'s body is placed and partitioned.
 */
@Operator
public final class StatefulPartitionedCall extends RawOp implements Iterable<Operand<TType>> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "StatefulPartitionedCall";

  private List<Output<?>> output;

  @SuppressWarnings("unchecked")
  private StatefulPartitionedCall(Operation operation) {
    super(operation);
    int outputIdx = 0;
    int outputLength = operation.outputListLength("output");
    output = Arrays.asList(operation.outputList(outputIdx, outputLength));
    outputIdx += outputLength;
  }

  /**
   * Factory method to create a class wrapping a new StatefulPartitionedCall operation.
   *
   * @param scope current scope
   * @param args A list of input tensors.
   * @param Tout A list of output types.
   * @param f <pre>
   *   A function that takes 'args', a list of tensors, and returns 'output',
   *   another list of tensors. Input and output types are specified by 'Tin'
   *   and 'Tout'. The function body of f will be placed and partitioned across
   *   devices, setting this op apart from the regular Call op. This op is
   *   stateful.
   * </pre>
   * @param options carries optional attribute values
   * @return a new instance of StatefulPartitionedCall
   */
  @Endpoint(
      describeByClass = true
  )
  public static StatefulPartitionedCall create(Scope scope, Iterable<Operand<?>> args,
      List<Class<? extends TType>> Tout, ConcreteFunction f, Options... options) {
    OperationBuilder opBuilder = scope.env().opBuilder("StatefulPartitionedCall", scope.makeOpName("StatefulPartitionedCall"));
    opBuilder.addInputList(Operands.asOutputs(args));
    opBuilder = scope.apply(opBuilder);
    opBuilder.setAttr("Tout", Operands.toDataTypes(Tout));
    opBuilder.setAttr("f", f);
    if (options != null) {
      for (Options opts : options) {
        if (opts.config != null) {
          opBuilder.setAttr("config", opts.config);
        }
        if (opts.configProto != null) {
          opBuilder.setAttr("config_proto", opts.configProto);
        }
        if (opts.executorType != null) {
          opBuilder.setAttr("executor_type", opts.executorType);
        }
      }
    }
    return new StatefulPartitionedCall(opBuilder.build());
  }

  /**
   * Sets the config option.
   *
   * @param config the config option
   * @return this Options instance.
   */
  public static Options config(String config) {
    return new Options().config(config);
  }

  /**
   * Sets the configProto option.
   *
   * @param configProto the configProto option
   * @return this Options instance.
   */
  public static Options configProto(String configProto) {
    return new Options().configProto(configProto);
  }

  /**
   * Sets the executorType option.
   *
   * @param executorType the executorType option
   * @return this Options instance.
   */
  public static Options executorType(String executorType) {
    return new Options().executorType(executorType);
  }

  /**
   * Gets output.
   * A list of return values.
   * @return output.
   */
  public List<Output<?>> output() {
    return output;
  }

  @Override
  @SuppressWarnings({"rawtypes", "unchecked"})
  public Iterator<Operand<TType>> iterator() {
    return (Iterator) output.iterator();
  }

  /**
   * Optional attributes for {@link org.tensorflow.op.core.StatefulPartitionedCall}
   */
  public static class Options {
    private String config;

    private String configProto;

    private String executorType;

    private Options() {
    }

    /**
     * Sets the config option.
     *
     * @param config the config option
     * @return this Options instance.
     */
    public Options config(String config) {
      this.config = config;
      return this;
    }

    /**
     * Sets the configProto option.
     *
     * @param configProto the configProto option
     * @return this Options instance.
     */
    public Options configProto(String configProto) {
      this.configProto = configProto;
      return this;
    }

    /**
     * Sets the executorType option.
     *
     * @param executorType the executorType option
     * @return this Options instance.
     */
    public Options executorType(String executorType) {
      this.executorType = executorType;
      return this;
    }
  }
}
