package com.contrastsecurity;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM7;

public class TestClassVisitor extends ClassVisitor {

  public TestClassVisitor(final ClassVisitor classVisitor) {
    super(ASM7, classVisitor);
  }

  @Override
  public MethodVisitor visitMethod(
      int access,
      String name,
      String descriptor,
      String signature,
      String[] exceptions) {
    final MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
    if("ping".equals(name) || "doGet".equals(name)){
      return new PingAdaptor(mv, access, name, descriptor);
    }else {
      return new TestMethodVisitor(mv);
    }
  }
}
