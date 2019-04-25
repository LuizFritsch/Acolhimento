/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.ControllerDELETE;
import controller.Log;
import java.util.ArrayList;

/**
 *
 * @author LuizFritsch
 */
public class FramePrincipal extends javax.swing.JFrame {

    ArrayList<String> listaTabelas;
    Log log;
    ControllerDELETE ac;

    /**
     * Creates new form Principal
     */
    public FramePrincipal() {
        initComponents();
        log = new Log();
        ac = new ControllerDELETE();
        listaTabelas = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoAcolhimentos = new javax.swing.JList<>();
        botaoPesquisarAcolhimentos = new javax.swing.JButton();
        botaoEditarAcolhimentos = new javax.swing.JButton();
        botaoExcluirAcolhimentos = new javax.swing.JButton();
        campoPesquisarAcolhimentos = new javax.swing.JTextField();
        botaoRealizarAcolhimento = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        botaoDeleteTudo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(campoAcolhimentos);

        botaoPesquisarAcolhimentos.setText("Pesquisar");

        botaoEditarAcolhimentos.setText("Editar");
        botaoEditarAcolhimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarAcolhimentosActionPerformed(evt);
            }
        });

        botaoExcluirAcolhimentos.setText("Excluir");
        botaoExcluirAcolhimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirAcolhimentosActionPerformed(evt);
            }
        });

        campoPesquisarAcolhimentos.setText("Digite o nome do paciente...");
        campoPesquisarAcolhimentos.setToolTipText("Digite o nome do paciente...");
        campoPesquisarAcolhimentos.setNextFocusableComponent(botaoPesquisarAcolhimentos);
        campoPesquisarAcolhimentos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPesquisarAcolhimentosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoPesquisarAcolhimentosFocusLost(evt);
            }
        });
        campoPesquisarAcolhimentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoPesquisarAcolhimentosMouseClicked(evt);
            }
        });
        campoPesquisarAcolhimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPesquisarAcolhimentosActionPerformed(evt);
            }
        });

        botaoRealizarAcolhimento.setText("Realizar Acolhimento");
        botaoRealizarAcolhimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRealizarAcolhimentoActionPerformed(evt);
            }
        });

        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        botaoDeleteTudo.setText("Deletar tudo do banco");
        botaoDeleteTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDeleteTudoActionPerformed(evt);
            }
        });

        jButton2.setText("cartaosus");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("residencia");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("profissoes");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("paciente");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("Deletar lista Tabela");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setText("Listar Tabelas Lista");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Limpar Lista Tabelas");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoPesquisarAcolhimentos)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(botaoDeleteTudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoPesquisarAcolhimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoEditarAcolhimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoExcluirAcolhimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoRealizarAcolhimento, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(campoPesquisarAcolhimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoPesquisarAcolhimentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoEditarAcolhimentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoExcluirAcolhimentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoRealizarAcolhimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoDeleteTudo)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton1)
                    .addComponent(jButton7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEditarAcolhimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarAcolhimentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoEditarAcolhimentosActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        /**
         * Sair do sistema
         */
        try {
            System.exit(0);
        } catch (Exception erro) {
            log.EscreveNoLog(erro.getMessage());
        }
    }//GEN-LAST:event_botaoSairActionPerformed

    private void campoPesquisarAcolhimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPesquisarAcolhimentosActionPerformed

    }//GEN-LAST:event_campoPesquisarAcolhimentosActionPerformed

    private void campoPesquisarAcolhimentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPesquisarAcolhimentosMouseClicked
        /**
         * Se o campo de pesquisa de acolhimentos estiver com o texto padrao, ao
         * clickar no campo, ele limpa tudo e o campo fica vazio
         */
        if (campoPesquisarAcolhimentos.getText().toString().equals("Digite o nome do paciente...")) {
            try {
                campoPesquisarAcolhimentos.setText("");
            } catch (Exception erro) {
                log.EscreveNoLog(erro.getMessage());
            }
        }


    }//GEN-LAST:event_campoPesquisarAcolhimentosMouseClicked

    private void campoPesquisarAcolhimentosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPesquisarAcolhimentosFocusGained

    }//GEN-LAST:event_campoPesquisarAcolhimentosFocusGained

    private void campoPesquisarAcolhimentosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPesquisarAcolhimentosFocusLost

    }//GEN-LAST:event_campoPesquisarAcolhimentosFocusLost

    private void botaoRealizarAcolhimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRealizarAcolhimentoActionPerformed
        /**
         * Abre o JFrame de acolhimento
         */
        try {
            Acolhimento dialog = new Acolhimento(this, rootPaneCheckingEnabled);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        } catch (Exception erro) {
            log.EscreveNoLog(erro.getMessage());
        }
    }//GEN-LAST:event_botaoRealizarAcolhimentoActionPerformed

    private void botaoExcluirAcolhimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirAcolhimentosActionPerformed
        try {

        } catch (Exception erro) {
            log.EscreveNoLog(erro.getMessage());
        }
    }//GEN-LAST:event_botaoExcluirAcolhimentosActionPerformed

    private void botaoDeleteTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeleteTudoActionPerformed
        try {
            ac.deleteTudo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_botaoDeleteTudoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        listaTabelas.add("cartaosus");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        listaTabelas.add("residencia");

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        listaTabelas.add("profissao");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        listaTabelas.add("paciente");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        for (String listaTabelas : listaTabelas) {
            System.out.println(listaTabelas);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            ac.deletePorTabela(listaTabelas);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        listaTabelas.clear();
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoDeleteTudo;
    private javax.swing.JButton botaoEditarAcolhimentos;
    private javax.swing.JButton botaoExcluirAcolhimentos;
    private javax.swing.JButton botaoPesquisarAcolhimentos;
    private javax.swing.JButton botaoRealizarAcolhimento;
    private javax.swing.JButton botaoSair;
    private javax.swing.JList<String> campoAcolhimentos;
    private javax.swing.JTextField campoPesquisarAcolhimentos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
