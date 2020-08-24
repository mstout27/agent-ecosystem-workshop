package com.contrastsecurity;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;

public class JerseyEndpointAdapter extends AdviceAdapter {

  protected JerseyEndpointAdapter(
      MethodVisitor methodVisitor,
      int access,
      String name,
      String descriptor) {
    super(ASM7, methodVisitor, access, name, descriptor);
  }

  @Override
  protected void onMethodEnter() {
    mv.visitVarInsn(Opcodes.ALOAD,0);
    mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
    push("ping message");
    mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
  }
}
