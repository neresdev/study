# Scaling Polices
## Target
- Basicamente é a clássica, caso eu configure ela para caso uma instância receba 70% de uma certa carga que eu estabelecer, será criada outra nova instância porém, se o tráfego vier MUITO maior que esses 70%, a minha aplicação pode ficar fora do ar ou ter problemas de performance e ficar instável

# Step / Simple Tracking
- É mais inteligente... Assim como a target, ela irá escalar caso bata os 70% porém, caso o tráfego exceda muito esses 70% (700% por exemplo) será criada n instâncias para suprir esse tráfego alto
- Para esse monitoramento é utilizado cloudwatch