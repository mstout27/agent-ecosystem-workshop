package com.contrastsecurity;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class TestTransformer implements ClassFileTransformer {

  @Override
  public byte[] transform(
      final ClassLoader loader,
      final String className,
      final Class<?> classBeingRedefined,
      final ProtectionDomain protectionDomain,
      final byte[] classfileBuffer)
      throws IllegalClassFormatException {
    final ClassReader classReader;
    try{
      classReader = new ClassReader(new ByteArrayInputStream(classfileBuffer));
    }
    catch (final IOException e){
      throw new IllegalArgumentException("Failed to read class: " + className, e);
    }
    final int flags = ClassWriter.COMPUTE_MAXS;
    final ClassWriter writer = new ClassWriter(flags);
    final ClassVisitor visitor = new TestClassVisitor(writer);
    classReader.accept(visitor, 0);
    return writer.toByteArray();
  }
}
