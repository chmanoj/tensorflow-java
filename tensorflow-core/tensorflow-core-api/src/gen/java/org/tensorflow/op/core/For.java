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
import org.tensorflow.types.TInt32;
import org.tensorflow.types.family.TType;

/**
 * <pre>
 *  output = input;
 *  for i in range(start, limit, delta)
 *    output = body(i, output);
 * </pre>
 */
@Operator
public final class For extends RawOp implements Iterable<Operand<TType>> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "For";

  private List<Output<?>> output;

  @SuppressWarnings("unchecked")
  private For(Operation operation) {
    super(operation);
    int outputIdx = 0;
    int outputLength = operation.outputListLength("output");
    output = Arrays.asList(operation.outputList(outputIdx, outputLength));
    outputIdx += outputLength;
  }

  /**
   * Factory method to create a class wrapping a new For operation.
   *
   * @param scope current scope
   * @param start The lower bound. An int32
   * @param limit The upper bound. An int32
   * @param delta The increment. An int32
   * @param input A list of input tensors whose types are T.
   * @param body <pre>
   * A function that takes a list of tensors (int32, T) and returns another
   * list of tensors (T).
   * </pre>
   * @return a new instance of For
   */
  @Endpoint(
      describeByClass = true
  )
  public static For create(Scope scope, Operand<TInt32> start, Operand<TInt32> limit,
      Operand<TInt32> delta, Iterable<Operand<?>> input, ConcreteFunction body) {
    OperationBuilder opBuilder = scope.env().opBuilder("For", scope.makeOpName("For"));
    opBuilder.addInput(start.asOutput());
    opBuilder.addInput(limit.asOutput());
    opBuilder.addInput(delta.asOutput());
    opBuilder.addInputList(Operands.asOutputs(input));
    opBuilder = scope.apply(opBuilder);
    opBuilder.setAttr("body", body);
    return new For(opBuilder.build());
  }

  /**
   * Gets output.
   * A list of output tensors whose types are T.
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
}
