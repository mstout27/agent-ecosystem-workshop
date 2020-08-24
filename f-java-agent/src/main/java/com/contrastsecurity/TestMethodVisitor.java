package com.contrastsecurity;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM7;

public class TestMethodVisitor extends MethodVisitor {

  TestMethodVisitor(final MethodVisitor methodVisitor) {
    super(ASM7, methodVisitor);
  }

  @Override
  public void visitLdcInsn(final Object value) {
    final Object newValue = "Hello world".equals(value) ? "Goodbye, world! :(" : value ;
    super.visitLdcInsn(newValue);
  }

}
