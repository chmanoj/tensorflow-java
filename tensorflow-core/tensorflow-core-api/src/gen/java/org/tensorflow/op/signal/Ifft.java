/* Copyright 2018-2022 The TensorFlow Authors. All Rights Reserved.

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

package org.tensorflow.op.signal;

import java.util.Arrays;
import org.tensorflow.GraphOperation;
import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.RawOpInputs;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.OpInputsMetadata;
import org.tensorflow.op.annotation.OpMetadata;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.proto.framework.DataType;
import org.tensorflow.types.family.TType;

/**
 * Inverse fast Fourier transform.
 * Computes the inverse 1-dimensional discrete Fourier transform over the
 * inner-most dimension of {@code input}.
 *
 * @param <T> data type for {@code output} output
 */
@OpMetadata(
    opType = Ifft.OP_NAME,
    inputsClass = Ifft.Inputs.class
)
@Operator(
    group = "signal"
)
public final class Ifft<T extends TType> extends RawOp implements Operand<T> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "IFFT";

  private Output<T> output;

  public Ifft(Operation operation) {
    super(operation, OP_NAME);
    int outputIdx = 0;
    output = operation.output(outputIdx++);
  }

  /**
   * Factory method to create a class wrapping a new IFFT operation.
   *
   * @param scope current scope
   * @param input A complex tensor.
   * @param <T> data type for {@code IFFT} output and operands
   * @return a new instance of Ifft
   */
  @Endpoint(
      describeByClass = true
  )
  public static <T extends TType> Ifft<T> create(Scope scope, Operand<T> input) {
    OperationBuilder opBuilder = scope.opBuilder(OP_NAME, "Ifft");
    opBuilder.addInput(input.asOutput());
    return new Ifft<>(opBuilder.build());
  }

  /**
   * Gets output.
   * A complex tensor of the same shape as {@code input}. The inner-most
   * dimension of {@code input} is replaced with its inverse 1D Fourier transform.
   * <p>{@literal @}compatibility(numpy)<br>
   * Equivalent to np.fft.ifft
   * <br>{@literal @}end_compatibility
   * @return output.
   */
  public Output<T> output() {
    return output;
  }

  @Override
  public Output<T> asOutput() {
    return output;
  }

  @OpInputsMetadata(
      outputsClass = Ifft.class
  )
  public static class Inputs<T extends TType> extends RawOpInputs<Ifft<T>> {
    /**
     * A complex tensor.
     */
    public final Operand<T> input;

    /**
     * The Tcomplex attribute
     */
    public final DataType Tcomplex;

    public Inputs(GraphOperation op) {
      super(new Ifft<>(op), op, Arrays.asList("Tcomplex"));
      int inputIndex = 0;
      input = (Operand<T>) op.input(inputIndex++);
      Tcomplex = op.attributes().getAttrType("Tcomplex");
    }
  }
}
