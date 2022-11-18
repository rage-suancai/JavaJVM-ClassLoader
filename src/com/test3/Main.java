package com.test3;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.io.FileOutputStream;
import java.io.IOException;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class Main {

    public static void main(String[] args) {

        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        writer.visit(V1_8, ACC_PUBLIC, "com/test3/Main", null, "java/lang/Object", null);
        MethodVisitor visitor = writer.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);

        visitor.visitCode();

        Label l1 = new Label();
        visitor.visitLabel(l1);
        visitor.visitLineNumber(11, l1);

        visitor.visitVarInsn(ALOAD, 0);
        visitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        visitor.visitInsn(RETURN);

        Label l2 = new Label();
        visitor.visitLabel(l2);
        visitor.visitLocalVariable("this", "Lcom/test3/Main", null, l1, l2, 0);

        visitor.visitMaxs(1, 1);
        visitor.visitEnd();

        MethodVisitor v2 = writer.visitMethod(ACC_PUBLIC | ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);

        v2.visitCode();

        Label l3 = new Label();
        v2.visitLabel(l3);
        v2.visitLineNumber(13, l3);
        v2.visitIntInsn(BIPUSH, 10);
        v2.visitVarInsn(ISTORE, 1);

        Label l4 = new Label();
        v2.visitLabel(l4);
        v2.visitLineNumber(14, l4);
        v2.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        v2.visitVarInsn(ILOAD, 1);
        v2.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

        Label l6 = new Label();
        v2.visitLabel(l6);
        v2.visitLineNumber(15, l6);
        v2.visitInsn(RETURN);
        Label l7 = new Label();
        v2.visitLabel(l7);

        v2.visitLocalVariable("args", "[Ljava/lang/String;", null, l3, l7, 0);
        v2.visitLocalVariable("a", "I", null, l4, l7, 1);
        v2.visitMaxs(1, 2);

        v2.visitEnd();
        writer.visitEnd();

        try(FileOutputStream stream = new FileOutputStream("./Main.class")) {
            stream.write(writer.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
