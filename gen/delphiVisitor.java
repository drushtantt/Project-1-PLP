// Generated from delphi.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link delphiParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface delphiVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link delphiParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(delphiParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#typeSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSection(delphiParser.TypeSectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classTypeDecl}
	 * labeled alternative in {@link delphiParser#typeDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassTypeDecl(delphiParser.ClassTypeDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code interfaceTypeDecl}
	 * labeled alternative in {@link delphiParser#typeDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceTypeDecl(delphiParser.InterfaceTypeDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(delphiParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#interfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType(delphiParser.InterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#interfaceMembers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMembers(delphiParser.InterfaceMembersContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#interfaceMethodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodDecl(delphiParser.InterfaceMethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#classMembers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMembers(delphiParser.ClassMembersContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#visibilitySection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisibilitySection(delphiParser.VisibilitySectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#classMemberDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDecl(delphiParser.ClassMemberDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(delphiParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#methodHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodHeader(delphiParser.MethodHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#constructorHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorHeader(delphiParser.ConstructorHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#destructorHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDestructorHeader(delphiParser.DestructorHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#procedureHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureHeader(delphiParser.ProcedureHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#functionHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionHeader(delphiParser.FunctionHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#methodImplSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodImplSection(delphiParser.MethodImplSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#methodImpl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodImpl(delphiParser.MethodImplContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#methodImplHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodImplHeader(delphiParser.MethodImplHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#varSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarSection(delphiParser.VarSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(delphiParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#idList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdList(delphiParser.IdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#formalParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParams(delphiParser.FormalParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#formalParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParam(delphiParser.FormalParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(delphiParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(delphiParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#stmtList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtList(delphiParser.StmtListContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(delphiParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#compoundStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStmt(delphiParser.CompoundStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#emptyStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStmt(delphiParser.EmptyStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(delphiParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue(delphiParser.LvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#callStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStmt(delphiParser.CallStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code builtinOrProcCall}
	 * labeled alternative in {@link delphiParser#callExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinOrProcCall(delphiParser.BuiltinOrProcCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodOrStaticCall}
	 * labeled alternative in {@link delphiParser#callExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodOrStaticCall(delphiParser.MethodOrStaticCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link delphiParser#actualParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParams(delphiParser.ActualParamsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(delphiParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExprAlt}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExprAlt(delphiParser.CallExprAltContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLit}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLit(delphiParser.IntLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(delphiParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lvalExpr}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalExpr(delphiParser.LvalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(delphiParser.MulDivContext ctx);
}