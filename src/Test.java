<Project Sdk="Microsoft.NET.Sdk">

  <PropertyGroup>
    <TargetFramework>netcoreapp3.1</TargetFramework>
  </PropertyGroup>

  <ItemGroup>
    <Compile Remove="Migrations\20200401125753_ModifiedIdentity1.cs" />
    <Compile Remove="Migrations\20200401125753_ModifiedIdentity1.Designer.cs" />
    <Compile Remove="Migrations\20200401141635_ExtendIdentity_BucketFolder.cs" />
    <Compile Remove="Migrations\20200401141635_ExtendIdentity_BucketFolder.Designer.cs" />
  </ItemGroup>

  <ItemGroup>
    <PackageReference Include="Microsoft.AspNetCore.Identity.EntityFrameworkCore" Version="3.1.3" />
    <PackageReference Include="Microsoft.EntityFrameworkCore.SqlServer" Version="3.1.3" />
    <PackageReference Include="Microsoft.EntityFrameworkCore.Tools" Version="3.1.3">
      <PrivateAssets>all</PrivateAssets>
      <IncludeAssets>runtime; build; native; contentfiles; analyzers; buildtransitive</IncludeAssets>
    </PackageReference>
  </ItemGroup>

</Project>
